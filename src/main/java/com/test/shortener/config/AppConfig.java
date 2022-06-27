package com.test.shortener.config;

import com.test.shortener.services.DBinstanciation;
import com.test.shortener.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class AppConfig {
    @Autowired
    private LinkService linkService;

    @Autowired
    private DBinstanciation dbInstanciation;

    @Value("create")
    private String strategy;

    @Bean
    public boolean dbInstance() {
        if (strategy.equals("create")) {
            this.dbInstanciation.dbInstance();
        }
        return false;
    }

}




