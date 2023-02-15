package com.comejia.dds.estado_prenda;

public class Promocion implements EstadoPrenda {

    private final Double descuento;

    public Promocion(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public Double precioFinal(Double precioBase) {
        return Math.max(precioBase - this.descuento, 0.0);
    }
}
