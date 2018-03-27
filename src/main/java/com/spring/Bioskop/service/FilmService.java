package com.spring.Bioskop.service;

import com.spring.Bioskop.model.Film;
import com.spring.Bioskop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public List<Film> getAll() {
        return filmRepository.findAll();
    }
    public Film save(Film f)
    {
        return filmRepository.save(f);
    }
}
