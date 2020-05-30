package com.flashtract.stocktrackerbackend.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.flashtract.stocktrackerbackend.model.StockModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

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

	public StockModel untrack(String key) {
        this.stockMap.remove(key);
        return null;
	}

    private StockModel getInternal(String key) throws IOException {
        StockQuote quote = YahooFinance.get(key).getQuote(true);
        BigDecimal price = quote.getPrice();
        StockModel stock = new StockModel(key, price, quote.getLastTradeTime());
        this.stockMap.put(key, stock);
        template.convertAndSend("/topic/public", stock);
        return stock;
    }

	public void update() throws IOException {
		for (Map.Entry<String, StockModel> entry : this.stockMap.entrySet()) {
            this.getInternal(entry.getKey());
        }
	}
}