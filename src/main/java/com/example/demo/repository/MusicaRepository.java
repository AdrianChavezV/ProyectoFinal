package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
