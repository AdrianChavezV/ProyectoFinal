package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Album;
import com.example.demo.model.Musica;
import com.example.demo.service.AlbumService;
import com.example.demo.service.MusicaService;

@Controller
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private MusicaService musicaService;

    @GetMapping("/musicas")
    public String getAllMusicas(Model model) {

        List<Musica> listMusicas = musicaService.getAllMusicas();

        model.addAttribute("musis", listMusicas);

        return "listMusica";
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<Album> albums = albumService.getAllAlbunes();
        model.addAttribute("albums", albums);

        return "registerMusica";
    }

    @PostMapping("/register")
    public String createMusica(@RequestParam("name") String nombre, @RequestParam("artista") String artista,
           @RequestParam("id") Long id,Model model) {

        Musica musica = new Musica();
        musica.nombre = nombre;
        musica.artista = artista;

        Album album = albumService.getAlbumById(id);

        musica.album = album;

        musicaService.createMusica(musica);

        model.addAttribute("musis", musicaService.getAllMusicas());
        model.addAttribute("albums", albumService.getAllAlbunes());

        return "listMusica";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Musica musica = musicaService.getMusicaById(id);

        model.addAttribute("musis", musica);
        model.addAttribute("albums", albumService.getAllAlbunes());

        return "editMusica";
    }

    @PostMapping("/edit")
    public String updateMusica(@RequestParam("name") String nombre, @RequestParam("artista") String artista,
            @RequestParam("id") Long id,Model model) {

        Musica musica = musicaService.getMusicaById(id);
        musica.nombre = nombre;
        musica.artista = artista;

        Album album = albumService.getAlbumById(id);

        musica.album = album;

        musicaService.createMusica(musica);

        model.addAttribute("musis", musicaService.getAllMusicas());
        model.addAttribute("albums", albumService.getAllAlbunes());

        return "listMusica";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusica(@PathVariable Long id, Model model) {
        musicaService.deleteMusica(id);

        model.addAttribute("musis", musicaService.getAllMusicas());
        model.addAttribute("albums", albumService.getAllAlbunes());

        return "listMusica";
    }
}
