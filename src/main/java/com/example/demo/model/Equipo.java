package com.example.demo.model;
public class Equipo {
    private String nombre;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    // Método para calcular la diferencia de goles
    public int getDiferenciaDeGoles() {
        return golesAFavor - golesEnContra;
    }

    // Método para actualizar estadísticas después de un partido
    public void actualizarEstadisticas(int golesFavor, int golesContra) {
        this.partidosJugados++;
        this.golesAFavor += golesFavor;
        this.golesEnContra += golesContra;

        if (golesFavor > golesContra) {
            this.partidosGanados++;
        } else {
            this.partidosPerdidos++;
        }
    }
}

