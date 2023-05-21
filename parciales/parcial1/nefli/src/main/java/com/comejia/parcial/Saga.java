package com.comejia.parcial;

import java.util.List;

public class Saga implements Contenido {
    List<Pelicula> peliculas;
    String genero;

    public boolean vista() {
        return this.peliculas.stream().allMatch(Pelicula::vista);
    }

    public Pelicula proximaAReprodudir() {
        return this.peliculas.stream()
                .filter(pelicula -> !pelicula.vista())
                .findFirst()
                .orElseThrow(() -> new RuntimeException(""));
    }

//    public Pelicula continuarViendo() {
//        return proximaAReprodudir();
//    }

    @Override
    public int likes() {
        return this.peliculas.stream().mapToInt(p -> p.likes()).sum();
    }

    @Override
    public boolean esDelGenero(String genero) {
        return this.genero.equals(genero);
    }

    @Override
    public boolean aptoTodoPublico() {
        return this.peliculas.stream().mapToInt(p -> p.getEdadRecomendada()).min().orElse(0) < 18;
    }

    @Override
    public String genero() {
        return this.genero;
    }

    public void reproducir() {
        proximaAReprodudir().reproducir();
    }

}
