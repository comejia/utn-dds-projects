package com.comejia.dds.estado_prenda;

public class Liquidacion implements EstadoPrenda {

    @Override
    public Double precioFinal(Double precioBase) {
        return precioBase * 0.5;
    }
}
