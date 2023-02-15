package com.comejia.parcial;

import java.util.List;

public class Saga implements Contenido {
    List<Pelicula> peliculas;

    public boolean vista() {
        return this.peliculas.stream().allMatch(Pelicula::vista);
    }

    public Pelicula proximaAReprodudir() {
        return this.peliculas.stream()
                .filter(pelicula -> !pelicula.vista())
                .findFirst()
                .orElseThrow(() -> new RuntimeException(""));
    }

    public Pelicula continuarViendo() {
        return proximaAReprodudir();
    }

}
