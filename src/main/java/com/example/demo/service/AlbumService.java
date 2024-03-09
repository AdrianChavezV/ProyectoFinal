package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Album;
import com.example.demo.repository.AlbumRepository;


@Service
public class AlbumService {
	@Autowired
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
