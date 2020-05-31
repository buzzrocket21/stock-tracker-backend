package com.flashtract.stocktrackerbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class StockUpdateEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockUpdateEventListener.class);

    @EventListener
    public void handleStockConnectEventListener(final SessionConnectedEvent event) {
        LOGGER.info("Stock Listener Connected");
    }

    @EventListener
    public void handleStockDisconnectEventListener(final SessionDisconnectEvent event) {
        LOGGER.info("Stock Listener Disconnected");
    }
}