package com.comejia.parcial;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tendencias implements Criterio {
    @Override
    public List<Contenido> sugerencias(List<Contenido> contenidos, Usuario usuario) {
        return contenidos.stream()
                .sorted(Comparator.comparing(Contenido::likes))
                .limit(10)
                .collect(Collectors.toList());
    }
}
