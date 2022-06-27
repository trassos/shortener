package com.test.shortener.resources.services;

import com.test.shortener.domain.Link;
import com.test.shortener.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LinkService {

    private Integer validForMinutes = 5;

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> findAll() {
        return linkRepository.findAll();
    }


    public List<Link> findByCuttedLink(Integer cuttedLink) {
        List<Link> link = linkRepository.findByCuttedLink(cuttedLink);
        return link;
    }


    public Link create(Link link) {
        link.setId(null);
        link.setCuttedLink(Shortcutting.Shortener(link.getUncuttedLink()));
        link.setCreationDate(LocalDateTime.now());
        return linkRepository.save(link);

    }
}
