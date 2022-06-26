package com.test.shortener.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Validating {
    public static boolean isValid (LocalDateTime time) {
        if ( time.plusMinutes(5).isBefore(LocalDateTime.now())) {
            return false;
        }else{
            return true;
        }

    }
}
