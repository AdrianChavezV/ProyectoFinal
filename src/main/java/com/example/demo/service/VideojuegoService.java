package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Videojuego;
import com.example.demo.repository.VideojuegoRepository;

public class VideojuegoService {
	
	@Autowired
	private VideojuegoRepository videojuegoRepository;
	
	public List<Videojuego> getAllVideojuegos() {
		return videojuegoRepository.findAll();
	}
	
	public Videojuego createVideojuego(Videojuego videojuego) {
		return videojuegoRepository.save(videojuego);
	}
	
	public Videojuego getVideojuegoById(long id) {
		return videojuegoRepository.findById(id).orElse(null);
	}
	public void deleteVideojuego(Long id) {
		videojuegoRepository.deleteById(id);
	}

}
