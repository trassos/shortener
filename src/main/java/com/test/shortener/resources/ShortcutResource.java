package com.test.shortener.resources;


import com.test.shortener.domain.Shortcut;
import com.test.shortener.services.ShortcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ShortcutResource {

    @Autowired
    private ShortcutService shortcutService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Shortcut>> findAll() {
        List<Shortcut> list = shortcutService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{cuttedLink}")
    public ResponseEntity<Void> redirect(@PathVariable Integer cuttedLink) {
        List<Shortcut> shortcut = shortcutService.findByCuttedLink(cuttedLink);
        String site = shortcut.get(0).getUncuttedLink();
        if (shortcutService.isValid(shortcut.get(0).getValidity())) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://" + site)).build();
        } else {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> create (@RequestBody Shortcut shortcut) {
        shortcut = shortcutService.create(shortcut);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shortcut.getId()).toUri();
        Integer site = shortcut.getCuttedLink();
        return ResponseEntity.created(uri).body("http://localhost:8080/"+site);
    }

}
