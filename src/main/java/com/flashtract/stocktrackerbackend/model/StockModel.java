package com.flashtract.stocktrackerbackend.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class StockModel {

    private String key;
    private String name;
    private BigDecimal price;
    private BigDecimal change;
    private Calendar time;

    public StockModel(
        String key,
        String name,
        BigDecimal price,
        Calendar time,
        BigDecimal change) {
        this.setKey(key);
        this.setName(name);
        this.setPrice(price);
        this.setTime(time);
        this.setChange(change);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
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