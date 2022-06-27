package com.test.shortener.resources;


import com.test.shortener.domain.Link;
import com.test.shortener.resources.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.test.shortener.resources.services.Validating.isValid;

@RestController
@RequestMapping
public class LinkResource {

    @Autowired
    private LinkService linkService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Link>> findAll() {
        List<Link> list = linkService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{cuttedLink}")
    public ResponseEntity<Void> redirect(@PathVariable Integer cuttedLink) {
        List<Link> link = linkService.findByCuttedLink(cuttedLink);
        String site = link.get(0).getUncuttedLink();
        if (isValid(link.get(0).getCreationDate())) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://" + site)).build();
        } else {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Link link) {

        link = linkService.create(link);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(link.getId()).toUri();
        Integer site = link.getCuttedLink();
        return ResponseEntity.created(uri).body("http://localhost:8080/" + site);

    }

}
