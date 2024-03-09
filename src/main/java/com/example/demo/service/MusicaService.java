package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Musica;

import com.example.demo.repository.MusicaRepository;

public class MusicaService {
	
	@Autowired
	private MusicaRepository musicaRepository;
	
	public List<Musica> getAllMusicas() {
		return musicaRepository.findAll();
	}
	
	public Musica createMusica(Musica musica) {
		return musicaRepository.save(musica);
	}
	
	public Musica getMusicaById(long id) {
		return musicaRepository.findById(id).orElse(null);
	}
	public void deleteMusica(Long id) {
		musicaRepository.deleteById(id);
	}

}
