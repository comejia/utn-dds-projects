package com.comejia.parcial;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioFabricas {

    List<Fabrica> fabricas;

    public void agregarFabrica(Fabrica fabrica) {
        this.fabricas.add(fabrica);
    }

    public List<Fabrica> fabricasDisponibles() {
        return this.fabricas.stream()
                .filter(Fabrica::aceptaOrden)
                .collect(Collectors.toList());
    }
}
