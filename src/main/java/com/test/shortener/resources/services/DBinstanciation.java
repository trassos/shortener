package com.test.shortener.resources.services;

import com.test.shortener.domain.Link;
import com.test.shortener.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBinstanciation {

    @Autowired
    private LinkRepository linkRepository;

    public void dbInstance() {
        Link sht = new Link(null,1, LocalDateTime.now().minusMinutes(10), "www.google.com");
        Link sht2 = new Link(null,2, LocalDateTime.now(), "www.yahoo.com");
        linkRepository.saveAll(Arrays.asList(sht, sht2));
    }
}
