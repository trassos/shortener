package com.test.shortener.services;

import com.test.shortener.domain.Shortcut;
import com.test.shortener.repositories.ShortcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ShortcutService {

    private Integer validForMinutes = 5;

    @Autowired
    private ShortcutRepository shortcutRepository;

    public List<Shortcut> findAll() {
        return shortcutRepository.findAll();
    }
    public List<Shortcut> findByCuttedLink(Integer cuttedLink) {
        List<Shortcut> shortcut = shortcutRepository.findByCuttedLink(cuttedLink);
        return shortcut;
    }
    public void dbInstance() {
        Shortcut sht = new Shortcut(null,1, LocalDateTime.now(), "www.google.com");
        Shortcut sht2 = new Shortcut(null,2, LocalDateTime.now(), "www.yahoo.com");
        shortcutRepository.saveAll(Arrays.asList(sht, sht2));
    }

    public Shortcut create(Shortcut shortcut) {
        shortcut.setId(null);
        shortcut.setCuttedLink(Shortener(shortcut.getUncuttedLink()));
        shortcut.setValidity(LocalDateTime.now());
        return shortcutRepository.save(shortcut);
    }

    public Integer Shortener (String site) {
        if (site.hashCode()<0) {
            return site.hashCode() * -1;
        } else {
            return site.hashCode();
        }
    }

    public boolean isValid (LocalDateTime time) {
        if ( time.plusMinutes(5).isBefore(LocalDateTime.now())) {
            return false;
        }else{
            return true;
        }

    }
}
