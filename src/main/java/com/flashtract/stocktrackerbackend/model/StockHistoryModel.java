package com.flashtract.stocktrackerbackend.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import yahoofinance.histquotes.HistoricalQuote;

public class StockHistoryModel extends StockModel {

    private List<HistoricalQuote> history;

    public StockHistoryModel(String key, String name, BigDecimal price, Calendar time, BigDecimal change,
            List<HistoricalQuote> history) {
        super(key, name, price, time, change);
        setHistory(history);
    }

    public List<HistoricalQuote> getHistory() {
        return history;
    }

    public void setHistory(List<HistoricalQuote> history) {
        this.history = history;
    }

}
