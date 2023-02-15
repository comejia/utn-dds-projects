package com.comejia.dds.estado_prenda;

public class Nueva implements EstadoPrenda {

    @Override
    public Double precioFinal(Double precioBase) {
        return precioBase;
    }
}
