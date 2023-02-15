package com.comejia.parcial;

import java.util.List;
import java.util.stream.Collectors;

public class AgregadosRecientemente implements Criterio {
    @Override
    public List<Contenido> sugerencias(List<Contenido> contenidos, Usuario usuario) {
        return contenidos.stream()
                .limit(10)
                .collect(Collectors.toList());
    }
}
