package com.spring.Bioskop.repository;


import com.spring.Bioskop.model.Projekcija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long> {
}
