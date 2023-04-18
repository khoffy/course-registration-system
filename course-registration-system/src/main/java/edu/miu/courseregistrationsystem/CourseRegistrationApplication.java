package edu.miu.courseregistrationsystem;

import edu.miu.courseregistrationsystem.config.ConfigFileExternalizationConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"edu.miu.courseregistrationsystem"})
@EntityScan(basePackages = {"edu.miu.courseregistrationsystem"})
@EnableJpaRepositories(basePackages = {"edu.miu.courseregistrationsystem"})
@OpenAPIDefinition
@EnableJms
@EnableScheduling
public class CourseRegistrationApplication {
    @Autowired
    JmsTemplate jmsTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseRegistrationApplication.class);

    public static void main(String[] args) {
        if (ConfigFileExternalizationConfig.createConfigFiles()
                != ConfigFileExternalizationConfig.CONFIG_FILES_ERROR_STATE) {
            ConfigurableApplicationContext app = new SpringApplicationBuilder(
                    CourseRegistrationApplication.class)
                    .build().run(ConfigFileExternalizationConfig.enhanceArgs(args));
            Environment env = app.getEnvironment();
            String protocol = "http";
            if (env.getProperty("server.ssl.key-store") != null) {
                protocol = "https";
            }
            LOGGER.info("\n----------------------------------------------------------\n\t"
                            + "Application '{}' is running! Access URLs:\n\t"
                            + "Local: \t\t{}://localhost:{}\n\t"
                            + "Profile(s): \t{}\n----------------------------------------------------------",
                    env.getProperty("spring.application.name"),
                    protocol,
                    env.getProperty("server.port"),
                    env.getActiveProfiles());
        } else {
            LOGGER.error("Please proceed to manually creation of configuration files!");
        }
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
