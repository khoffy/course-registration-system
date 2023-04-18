package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.repository.RegistrationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Rediet
 * @version 1.0
 * @created 20-Dec-2022 4:38 PM
 */
@Component
public class RegistrationEventEmailSender {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    @Scheduled(cron = "0 0 12 ? * ?")
//    @Scheduled(fixedRate = 20000)
    public void sendEmailReminder() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currentTime = timeFormatter.format(date);
        System.out.println("This task runs at " + currentTime);
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        jmsTemplate.convertAndSend("registrationEventQueue1", "registrationEvents");
        for(RegistrationEvent registrationEvent: registrationEvents){
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(registrationEvent.getEndDate(), now);
            if(duration.toHours() == 4 || duration.toHours() == 8) {

                jmsTemplate.convertAndSend("OpenRegistrationEventQueue",
                        "Registration will be closed after" + duration.toHours() + " hours");

            }
        }
    }

}
