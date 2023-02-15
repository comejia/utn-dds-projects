package com.comejia.parcial;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeneroFavorito implements Criterio {
    @Override
    public List<Contenido> sugerencias(List<Contenido> contenidos, Usuario usuario) {
        return contenidos.stream()
                .filter(contenido -> contenido.esDelGenero(usuario.getGeneroFavorito()))
                .sorted(Comparator.comparing(Contenido::likes))
                .limit(10)
                .collect(Collectors.toList());
    }
}
