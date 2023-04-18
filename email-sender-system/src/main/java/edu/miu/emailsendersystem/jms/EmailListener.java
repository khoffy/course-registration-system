package edu.miu.emailsendersystem.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @JmsListener(destination = "registrationEventQueue1")
    public void receiveMessage(final String emailAsString) {
        System.out.println("JMS receiver received message:" + emailAsString);
    }
    @JmsListener(destination = "testQueueNew")
    public void receiveMessage2(final String emailAsString) {
        System.out.println("JMS receiver received message:" + emailAsString);
    }
}
