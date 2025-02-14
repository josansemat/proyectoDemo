package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.PersonaService;
import com.example.demo.model.Persona;

@RestController
public class HolaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/hola")
    public String saludar() {
        Persona persona = personaService.obtenerPersonaPorNombre("Pepe");
        return "Hola " + (persona);
        //pepe
    }
}