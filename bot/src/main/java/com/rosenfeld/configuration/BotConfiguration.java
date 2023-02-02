package com.rosenfeld.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.rosenfeld")
@PropertySource("application.properties")
@Getter
public class BotConfiguration {

    @Value("${bot.username}")
    private String userName;

    @Value("${bot.token}")
    private String token;


}
