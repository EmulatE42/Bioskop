package com.spring.Bioskop.repository;

import com.spring.Bioskop.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    @Query("Select k from Korisnik k WHERE k.korisnickoIme = :auth or k.email = :auth")
    Korisnik findByUsernameOrEmail(@Param("auth") String username);


}
