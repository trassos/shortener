package com.test.shortener.config;

import com.test.shortener.domain.Shortcut;
import com.test.shortener.repositories.ShortcutRepository;
import com.test.shortener.services.ShortcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("dev")
public class AppConfig {
    @Autowired
    private ShortcutService shortcutService;

    @Value("create")
    private String strategy;

    @Bean
    public boolean dbInstance() {
        if (strategy.equals("create")) {
            this.shortcutService.dbInstance();
        }
        return false;
    }

}




