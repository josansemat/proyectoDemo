package com.example.demo.controller;

import com.example.demo.model.Equipo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EquipoController {
    @GetMapping("/listarEquipos")
    public String listarEquipos(HttpSession session, Model model) {
        List<Equipo> equipos = (List<Equipo>) session.getAttribute("equipos");
if (equipos == null) {
    equipos = new ArrayList<>();
}

// Ordenar la lista de equipos alfabéticamente por nombre usando el algoritmo de ordenación por burbuja
for (int i = 0; i < equipos.size() - 1; i++) {
    for (int j = 0; j < equipos.size() - i - 1; j++) {
        if (equipos.get(j).getNombre().compareTo(equipos.get(j + 1).getNombre()) > 0) {
            // Intercambiar equipos[j] y equipos[j + 1]
            Equipo temp = equipos.get(j);
            equipos.set(j, equipos.get(j + 1));
            equipos.set(j + 1, temp);
        }
    }
}

model.addAttribute("equipos", equipos);
        return "listarEquipos";
    }

    @GetMapping("/crearEquipo")
    public String crearEquipo() {
        return "crearEquipo";
    }

    @PostMapping("/guardarEquipo")
    public String guardarEquipo(@RequestParam String nombre, HttpSession session) {//es capaz de leer los parámetros que adjuntemos
        List<Equipo> equipos = (List<Equipo>) session.getAttribute("equipos");
        if (equipos == null) {
            equipos = new ArrayList<>();
        }
        equipos.add(new Equipo(nombre));
        session.setAttribute("equipos", equipos);
        return "redirect:/listarEquipos";
    }

    @GetMapping("/estadisticas")
    public String estadisticasEquipos(HttpSession session, Model model) {
        List<Equipo> equipos = (List<Equipo>) session.getAttribute("equipos");
        if (equipos == null) {
            equipos = new ArrayList<>();
        }
        model.addAttribute("equipos", equipos);
        return "estadisticas";
    }
}
