package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Date;

@EnableBinding(Processor.class)
public class EventProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventProcessor.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Potato listener(Potato potato) {
        LOGGER.debug("Event processor received message: " + potato);
        potato.setMessage(potato.getMessage() + "\nI saw this one.");
        potato.setModifiedAt(new Date());
        LOGGER.debug("Event processor enriched potato: " + potato);
        return potato;
    }

}
