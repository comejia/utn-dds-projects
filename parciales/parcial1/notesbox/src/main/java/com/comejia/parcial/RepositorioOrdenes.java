package com.comejia.parcial;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioOrdenes {

    List<Orden> ordenes;

    public List<Orden> ordenesPendientes() {
        return this.ordenes.stream()
                .filter(Orden::pendiente)
                .collect(Collectors.toList());
    }
}
