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

import com.example.demo.model.Genero;
import com.example.demo.model.Videojuego;
import com.example.demo.service.GeneroService;
import com.example.demo.service.VideojuegoService;

@Controller
@RequestMapping("/videojuego")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;
    
    @Autowired
    private GeneroService generoService;

    @GetMapping("/videojuegos")
    public String getAllVideojuegos(Model model) {

        List<Videojuego> listVideojuegos = videojuegoService.getAllVideojuegos();

        model.addAttribute("videos", listVideojuegos);

        return "listVideojuegos";
    }

    @PostMapping("/register_videojuego")
    public String createVideojuego(@RequestParam("name") String nombre, @RequestParam("company") String company,
            @RequestParam("fechaEstreno") String fechaEstreno,
            @RequestParam("id") Long id, Model model) {

        Videojuego videojuego = new Videojuego();
        videojuego.nombre = nombre;
        videojuego.company = company;
        videojuego.fechaEstreno = fechaEstreno;


        Genero genero = generoService.getGeneroById(id);
        videojuego.genero = genero;

        videojuegoService.createVideojuego(videojuego);

        model.addAttribute("videos", videojuegoService.getAllVideojuegos());
        model.addAttribute("generos", generoService.getAllGeneros());

        return "listVideojuegos";
    }

    @GetMapping("/edit_videojuego/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Videojuego videojuego = videojuegoService.getVideojuegoById(id);

        model.addAttribute("videos", videojuego);
        model.addAttribute("generos", generoService.getAllGeneros());

        return "videojuegoEdit";
    }

    @PostMapping("/edit_videojuego")
    public String updateVideojuego(@RequestParam("name") String nombre, @RequestParam("company") String company,
            @RequestParam("fechaEstreno") String fechaEstreno,
            @RequestParam("id") Long id, Model model) {

        Videojuego videojuego = new Videojuego();
        videojuego.nombre = nombre;
        videojuego.company = company;
        videojuego.fechaEstreno = fechaEstreno;
 

        Genero genero = generoService.getGeneroById(id);
       videojuego.genero = genero;

        videojuegoService.createVideojuego(videojuego);

        model.addAttribute("videos", videojuegoService.getAllVideojuegos());
        model.addAttribute("generos", generoService.getAllGeneros());

        return "listVideojuegos";
    }

    @GetMapping("/delete_videojuego/{id}")
    public String deleteVideojuego(@PathVariable Long id, Model model) {
        videojuegoService.deleteVideojuego(id);

        model.addAttribute("videos", videojuegoService.getAllVideojuegos());
        model.addAttribute("generos", generoService.getAllGeneros());

        return "listVideojuegos";
    }
}
