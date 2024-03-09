package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "musica")
public class Musica {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMusica", nullable = false)
    public Long id;

    @Column(name = "nombre", nullable = false)
	public String nombre;

    @Column(name = "artista", nullable = false)
    public String director;

    @Column(name = "genero", nullable = false)
    public String genero;

    @ManyToOne
    @JoinColumn(name = "album")
    public Album album;

}
