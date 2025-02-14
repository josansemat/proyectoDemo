package com.example.demo.controller;

import com.example.demo.model.Equipo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class PartidoController {
    @GetMapping("/jugarPartido")
    public String jugarPartido(HttpSession session, Model model) {
        List<Equipo> equipos = (List<Equipo>) session.getAttribute("equipos");
        model.addAttribute("equipos", equipos);
        return "jugarPartido";
    }

    @PostMapping("/procesarPartido")
    public String procesarPartido(
            @RequestParam String equipo1,
            @RequestParam String equipo2,
            HttpSession session,
            Model model) {

        List<Equipo> equipos = (List<Equipo>) session.getAttribute("equipos");
        //asignar los equipos a las variables equipoLocal y equipoVisitante
        Equipo equipoLocal = null;
        Equipo equipoVisitante = null;
        
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(equipo1)) {
                equipoLocal = equipo;
            }
            if (equipo.getNombre().equals(equipo2)) {
                equipoVisitante = equipo;
            }
            if (equipoLocal != null && equipoVisitante != null) {
                break;
            }
        }

        //procesar el partido y actualizar las estadísticas de los equipos
        if (equipoLocal != null && equipoVisitante != null) {
            Random random = new Random();
            int golesLocal = random.nextInt(5);
            int golesVisitante = random.nextInt(5);

            equipoLocal.actualizarEstadisticas(golesLocal, golesVisitante);
            equipoVisitante.actualizarEstadisticas(golesVisitante, golesLocal);

            model.addAttribute("equipoLocal", equipoLocal);
            model.addAttribute("equipoVisitante", equipoVisitante);
            model.addAttribute("golesLocal", golesLocal);
            model.addAttribute("golesVisitante", golesVisitante);
        }

        return "resultadoPartido";
    }
}
