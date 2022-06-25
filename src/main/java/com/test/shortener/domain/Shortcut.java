package com.test.shortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Shortcut implements Serializable {

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

    private LocalDateTime validity;

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

    public LocalDateTime getValidity() {
        return validity;
    }

    public void setValidity(LocalDateTime validity) {
        this.validity = validity;
    }

    public Shortcut() {
    }

    public Shortcut(Integer id, Integer cuttedLink, LocalDateTime validity, String uncuttedLink) {
        this.id = id;
        this.cuttedLink = cuttedLink;
        this.validity = validity;
        this.uncuttedLink = uncuttedLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shortcut shortcut = (Shortcut) o;
        return Objects.equals(getId(), shortcut.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
