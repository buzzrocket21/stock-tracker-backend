package com.flashtract.stocktrackerbackend.controller;

import java.io.IOException;

import com.flashtract.stocktrackerbackend.model.StockModel;
import com.flashtract.stocktrackerbackend.service.StockTrackerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class StockTrackerWebsocketController {
    @Autowired
    StockTrackerService stockService;

    @MessageMapping("/track")
    public StockModel trackStock(@Payload final String key) throws IOException {
        return stockService.track(key);
    }

    @MessageMapping("/untrack")
    public void untrackStock(@Payload final String key) throws IOException {
        stockService.untrack(key);
    }
}