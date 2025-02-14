package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.model.Persona;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona obtenerPersonaPorNombre(String nombre) {
        return personaRepository.findAll().stream()
                .filter(persona -> persona.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}