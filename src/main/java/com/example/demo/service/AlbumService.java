package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Album;
import com.example.demo.repository.AlbumRepository;



public class AlbumService {
	
	private AlbumRepository albumRepository;
	
	public List<Album> getAllAlbunes() {
		return albumRepository.findAll();
	}
	
	public Album createAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	public Album getAlbumById(long id) {
		return albumRepository.findById(id).orElse(null);
	}

}
