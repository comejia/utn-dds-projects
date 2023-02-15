package com.comejia.parcial;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Fabrica {

    int capacidadProduccion;
    List<Orden> ordenesTomadas;

    public int tiempoFabricacion() {
        return 10;
    }

    public boolean aceptaOrden() {
        return this.ordenesTomadas() < this.capacidadProduccion;
    }

    public int ordenesTomadas() {
        return this.ordenesTomadas.size();
    }

    public void asignar(Orden orden) {
        orden.asignar(this);
        this.ordenesTomadas.add(orden);
    }

    public List<Orden> ordenesAsignadaEn(LocalDateTime inicio, LocalDateTime fin) {
        return this.ordenesTomadas.stream()
                .filter(o -> o.estaEnPeriodo(inicio, fin))
                .collect(Collectors.toList());
    }
}
