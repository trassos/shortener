package com.test.shortener.repositories;

import com.test.shortener.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

//    @Query("SELECT obj FROM Book obj ORDER BY title")
    List<Link> findByCuttedLink(@Param(value = "cuttedLink") Integer cuttedLink);
//WHERE obj.cuttedLink = :cuttedLink
}
