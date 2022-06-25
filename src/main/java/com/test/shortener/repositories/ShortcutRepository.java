package com.test.shortener.repositories;

import com.test.shortener.domain.Shortcut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShortcutRepository extends JpaRepository<Shortcut, Integer> {

//    @Query("SELECT obj FROM Book obj ORDER BY title")
    List<Shortcut> findByCuttedLink(@Param(value = "cuttedLink") Integer cuttedLink);
//WHERE obj.cuttedLink = :cuttedLink
}
