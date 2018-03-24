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
@Table(name = "sala")

public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salaID", unique = true, nullable = false)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "maksimalniBrojReda")
    private int maksimalniBrojReda;

    @Column(name = "maksimalnoSediste")
    private char maksimalnoSediste;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<Projekcija> projekcije;
}
