package com.spring.Bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
@Table(name = "projekcija")
public class Projekcija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projekcijaID", unique = true, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "projekcija", cascade = CascadeType.ALL)
    public List<Karta> karte;

    @Column(name = "datumProjekcije")
    private String datumProjekcije;

    @Column(name = "nazivFilma")
    private String nazivFilma;


    @Column(name = "cena")
    private int cena;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    public Sala sala;

}
