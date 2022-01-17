package com.wejo.consent.sandbox.azure.servicebus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class QueueReceiver {
    private final Logger logger = LoggerFactory.getLogger(QueueReceiver.class);
 
 
    @JmsListener(destination = "datapoints_to_store")
    public void onMessage(DataPoint message) {
        logger.info("Received message from queue: {}", message);
    }
}