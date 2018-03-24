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
@Table(name = "karta")
public class Karta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kartaID", unique = true, nullable = false)
    private Long id;

    @Column(name = "korisnickoImeKupca")
    private String korisnickoImeKupca;

    @Column(name = "oznakaSedista")
    private String oznakaSedista;

    @Column(name = "datumProdaje")
    private String datumProdaje;

    @ManyToOne
    @JoinColumn(name = "projekcija_ID")
    public Projekcija projekcija;

}
