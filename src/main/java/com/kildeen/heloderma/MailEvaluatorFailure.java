
package com.kildeen.heloderma;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MailEvaluatorFailure implements TriggeringEventEvaluator {
	private static Logger log = LoggerFactory.getLogger(Pinger.class);

    public boolean isTriggeringEvent(LoggingEvent e) {
    	if (e.getLevel() == Level.ERROR) {
    		log.info("Error detected, will attempt to send mail");
    		return true;
    	}
    	else return false;
    }

}
