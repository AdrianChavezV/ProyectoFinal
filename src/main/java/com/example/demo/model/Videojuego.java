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
@Table(name = "videojuego")
public class Videojuego {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVideojuego", nullable = false)
    public Long id;

    @Column(name = "nombre", nullable = false)
	public String nombre;

    @Column(name = "company", nullable = false)
    public String company;

    @Column(name = "fechaEstreno", nullable = false)
    public String fechaEstreno;
    
    @Column(name = "genero", nullable = false)
    public Genero genero;

    /*
    @ManyToOne
    @JoinColumn(name = "genero")
    public Genero genero;
    */

}
