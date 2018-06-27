package com.spring.Bioskop.controller;

import com.spring.Bioskop.model.Film;
import com.spring.Bioskop.model.Korisnik;
import com.spring.Bioskop.repository.FilmRepository;
import com.spring.Bioskop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    FilmService filmService;



    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }


    @GetMapping("/favicon.ico")
    public String index2() {
        return "Hello there! I'm running.";
    }


    @CrossOrigin
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Film> saveMovie(@RequestBody Film k) {
        //System.out.println("DOBIO SAM " + k);
        Film f = this.filmService.save(k);
        return new ResponseEntity(f != null ? f : "{}", HttpStatus.OK);
    }



    @CrossOrigin
    @RequestMapping(value = "/getAllMovies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Film>> getAllMovies() {
        List<Film> movies = this.filmService.getAll();
        //System.out.println("size "+ movies.size());
        return new ResponseEntity(movies != null ? movies : "{}", HttpStatus.OK);
    }
}
