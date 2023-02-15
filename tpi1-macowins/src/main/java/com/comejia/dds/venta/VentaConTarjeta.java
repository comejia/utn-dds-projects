package com.comejia.dds.venta;

import com.comejia.dds.producto.Item;

import java.util.Date;
import java.util.List;

public class VentaConTarjeta extends Venta {

    private final Double cantidadCuotas;
    private final Double coeficienteTarjeta = 0.8;

    public VentaConTarjeta(List<Item> items, Date fecha, Double cuotas) {
        super(items, fecha);
        this.cantidadCuotas = cuotas;
    }

    @Override
    public Double recargo(Double importeBase) {
        return this.cantidadCuotas * this.coeficienteTarjeta + 0.01 * importeBase;
    }
}
