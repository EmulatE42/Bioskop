package com.spring.Bioskop.service;

import com.spring.Bioskop.model.Projekcija;
import com.spring.Bioskop.repository.ProjekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjekcijaService {
    @Autowired
    ProjekcijaRepository projekcijaRepository;

    public List<Projekcija> getAll() {
        return projekcijaRepository.findAll();
    }
    public Projekcija save(Projekcija f)
    {
        return projekcijaRepository.save(f);
    }
}
