package com.spring.Bioskop.controller;

import com.spring.Bioskop.model.Korisnik;
import com.spring.Bioskop.model.Projekcija;
import com.spring.Bioskop.service.ProjekcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProjekcijaController {

    @Autowired
    ProjekcijaService projekcijaService;

    @CrossOrigin
    @RequestMapping(value = "/savePro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projekcija> savePro(@RequestBody Projekcija k) {
        //System.out.println("DOBIO SAM " + k);
        Projekcija p = this.projekcijaService.save(k);
        return new ResponseEntity(p != null ? p : "{}", HttpStatus.OK);
    }



    @CrossOrigin
    @RequestMapping(value = "/getAllPro", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Projekcija>> getAllPro() {
        List<Projekcija> p = this.projekcijaService.getAll();
        System.out.println(p.size() + "aloooo");
        return new ResponseEntity(p != null ? p : "{}", HttpStatus.OK);
    }
}
