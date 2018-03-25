package com.spring.Bioskop.repository;

import com.spring.Bioskop.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    @Query("Select k from Korisnik k WHERE k.korisnickoIme = :auth or k.email = :auth")
    Korisnik findByUsernameOrEmail(@Param("auth") String username);

    @Modifying
    @Transactional
    @Query("Update Korisnik k SET k.lozinka=:nova WHERE k.email=:email")
    int updatePassword(@Param("email") String email, @Param("nova") String nova);

}
