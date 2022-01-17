package com.wejo.consent.sandbox.azure.servicebus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    private static final String DESTINATION_NAME = "DATAPOINTS_TO_STORE";

    private static final Logger logger = LoggerFactory.getLogger(SendController.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    
    @GetMapping("/datapoints/{dataId}/{dataValue}")
    public ResponseEntity<Void> postMessage(@PathVariable String dataId, @PathVariable String dataValue) {
        logger.info("Sending message");
        jmsTemplate.convertAndSend(DESTINATION_NAME,
        		new DataPoint(dataId, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
        				dataValue));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
