package com.spring.Bioskop.repository;

import com.spring.Bioskop.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<Film, Long> {
}
