package com.flashtract.stocktrackerbackend.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockTrackerScheduler {

    @Autowired
    private StockTrackerService stockTrackerService;

    @Scheduled(fixedDelay = 5000)
    public void updateStock() throws IOException {
        stockTrackerService.update();
    }
}