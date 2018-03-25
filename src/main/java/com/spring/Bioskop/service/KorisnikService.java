package com.spring.Bioskop.service;

import com.spring.Bioskop.model.Korisnik;
import com.spring.Bioskop.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik save(Korisnik k) {
        k.setLozinka(encryptAndSalt(k.getLozinka(), k.getEmail()));
        return korisnikRepository.save(k);
    }

    public Korisnik login(String auth, String lozinka) {

        Korisnik k = korisnikRepository.findByUsernameOrEmail(auth);
        System.out.println(k == null);
        if (k != null) {

            lozinka = encryptAndSalt(lozinka, k.getEmail());
            System.out.println(lozinka);
            if (!k.getLozinka().equals(lozinka)) {
                return null;
            }
        }
        return k;

    }

    public String encryptAndSalt(String unecryptedPassword, String email) {

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update((unecryptedPassword + email).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
        System.out.println("Encrypted Password: " + encryptedPassword + " " + encryptedPassword.length());
        return encryptedPassword;

    }

    public List<Korisnik> getAll() {
        return korisnikRepository.findAll();
    }

    public void updatePassword(String email, String lozinka)
    {
        lozinka = encryptAndSalt(lozinka, email);
        korisnikRepository.updatePassword(email,lozinka);
    }

}
