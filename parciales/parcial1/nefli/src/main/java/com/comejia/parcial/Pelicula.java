package com.comejia.parcial;

import java.util.Comparator;
import java.util.List;

public class Pelicula implements Contenido {
    List<Resolucion> resoluciones;
    int id;
    int tiempoReproduccion = 0;
    boolean estaVista = false;
    String genero;
    int likes = 0;
    int edadRecomendad;

    public Resolucion resolucionConMayorCalidad() {
        return this.resoluciones.stream()
                .max(Comparator.comparing(Resolucion::getResolucion))
                .orElseThrow(RuntimeException::new);
    }


    public void marcarComoVista() {
        this.estaVista = true;
    }
    public boolean vista() {
        return this.estaVista;
    }

    /*public Pelicula continuarViendo() {
        return this;
    }*/

    public void meGusta() {
        this.likes++;
    }

    public int getEdadRecomendada() {
        return this.edadRecomendad;
    }

    @Override
    public int likes() {
        return this.likes;
    }

    @Override
    public boolean esDelGenero(String genero) {
        return this.genero.equals(genero);
    }

    @Override
    public boolean aptoTodoPublico() {
        return this.edadRecomendad  < 18;
    }

    @Override
    public String genero() {
        return this.genero;
    }

    public void reproducir() {

    }
}
