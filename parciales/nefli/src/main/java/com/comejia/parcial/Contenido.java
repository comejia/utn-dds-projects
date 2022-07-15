package com.comejia.parcial;

public interface Contenido {
    boolean vista();
    Pelicula continuarViendo();

    int likes();

    boolean esDelGenero(String generoFavorito);

    boolean aptoTodoPublico();

    Object genero();
}
