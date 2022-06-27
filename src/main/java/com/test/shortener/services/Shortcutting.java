package com.test.shortener.services;

import org.springframework.stereotype.Service;

@Service
public class Shortcutting {


    public static Integer Shortener(String site) {

            if (site.hashCode() < 0) {
                return site.hashCode() * -1;
            } else {
                return site.hashCode();
            }

    }
}
