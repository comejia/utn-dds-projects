package com.comejia.parcial;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioContenidos {
    List<Contenido> contenidos;

    static RepositorioContenidos instance = new RepositorioContenidos();

    public static RepositorioContenidos instance() {
        return instance;
    }

    public List<Contenido> contenidosPendientesDeTerminar() {
        return this.contenidos.stream()
                .filter(contenido -> !contenido.vista())
                .collect(Collectors.toList());
    }

    public List<Contenido> getContenidos() {
        return this.contenidos;
    }
}
