package com.flashtract.stocktrackerbackend.controller;

import java.io.IOException;

import com.flashtract.stocktrackerbackend.model.StockHistoryModel;
import com.flashtract.stocktrackerbackend.service.StockTrackerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockTrackerRestController {
    @Autowired
    private StockTrackerService stockService;

    @CrossOrigin(origins = "*")
    @GetMapping("/history/{key}")
    public StockHistoryModel getHistory(@PathVariable String key) throws IOException {
        return stockService.getHistory(key);
    }
    
}