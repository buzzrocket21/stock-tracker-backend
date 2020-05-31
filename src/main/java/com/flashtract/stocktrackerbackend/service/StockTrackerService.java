package com.flashtract.stocktrackerbackend.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.flashtract.stocktrackerbackend.model.StockModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

@Service
public class StockTrackerService {
    @Autowired
    SimpMessagingTemplate template;

    private Map<String, StockModel> stockMap = new HashMap<String, StockModel>();

    public StockModel track(String key) throws IOException {
        this.stockMap.put(key, null);
        return this.getInternal(key);
    }

	public void untrack(String key) {
        this.stockMap.remove(key);
	}

    private StockModel getInternal(String key) throws IOException {
        Stock stock = YahooFinance.get(key);
        if(stock == null) {
            return null;
        }
        StockQuote quote = stock.getQuote(true);
        BigDecimal price = quote.getPrice();
        String name = stock.getName();
        StockModel stockModel = new StockModel(
            key,
            name,
            price,
            quote.getLastTradeTime(),
            quote.getChange()
        );
        this.stockMap.put(key, stockModel);
        template.convertAndSend("/topic/public", stockModel);
        return stockModel;
    }

	public void update() throws IOException {
		for (Map.Entry<String, StockModel> entry : this.stockMap.entrySet()) {
            this.getInternal(entry.getKey());
        }
	}
}