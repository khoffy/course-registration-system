package edu.miu.emailsendersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class EmailSenderSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSenderSystemApplication.class, args);
    }

}
