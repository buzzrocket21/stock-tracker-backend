package com.flashtract.stocktrackerbackend.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class StockModel {

    private String key;
    private BigDecimal price;
    private Calendar time;

	public StockModel(String key, BigDecimal price, Calendar time) {
        this.key = key;
        this.price = price;
        this.time = time;
    }
    
	public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Calendar getTime() {
        return this.time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
}