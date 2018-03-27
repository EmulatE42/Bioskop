package com.spring.Bioskop.controller;


import com.spring.Bioskop.model.Korisnik;
import com.spring.Bioskop.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KorisnikController {

    @Autowired
    KorisnikService korisnikService;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> login(@RequestBody String k) {
        //System.out.println(k);
        k = k.replace("\"", "");
        String[] el = k.split(";");
        Korisnik user = this.korisnikService.login(el[0], el[1]);
        System.out.println("Vracam " + user);
        return new ResponseEntity(user != null ? user : "{}", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> register(@RequestBody Korisnik k) {
        System.out.println("DOBIO SAM " + k);
        Korisnik user = this.korisnikService.save(k);
        return new ResponseEntity(user != null ? user : "{}", HttpStatus.OK);
    }



    @CrossOrigin
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> getAllUsers() {
        List<Korisnik> users = this.korisnikService.getAll();
        System.out.println(users.size());
        return new ResponseEntity(users != null ? users : "{}", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> update(@RequestBody String k) {
        //System.out.println(k);
        k = k.replace("\"", "");
        String[] el = k.split(";");
        this.korisnikService.updatePassword(el[0], el[1]);

        return new ResponseEntity(true, HttpStatus.OK);
    }


}
