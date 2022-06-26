package com.test.shortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer cuttedLink;

    private LocalDateTime creationDate;

    private String uncuttedLink;

    public String getUncuttedLink() {
        return uncuttedLink;
    }

    public void setUncuttedLink(String uncuttedLink) {
        this.uncuttedLink = uncuttedLink;
    }

    public Integer getCuttedLink() {
        return cuttedLink;
    }

    public void setCuttedLink(Integer cuttedLink) {
        this.cuttedLink = cuttedLink;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Link() {
    }

    public Link(Integer id, Integer cuttedLink, LocalDateTime creationDate, String uncuttedLink) {
        this.id = id;
        this.cuttedLink = cuttedLink;
        this.creationDate = creationDate;
        this.uncuttedLink = uncuttedLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(getId(), link.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
