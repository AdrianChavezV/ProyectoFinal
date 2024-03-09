package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

}
