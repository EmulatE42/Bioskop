package com.spring.Bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmID", unique = true, nullable = false)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "zanr")
    private String zanr;

    @Column(name = "godinaProizvodnje")
    private int godinaProizvodnje;

    @Column(name = "trajanje")
    private int trajanje;

    @Column(name = "zemljaPorekla")
    private String zemljaPorekla;

    @Column(name = "opis")
    private String opis;
}
