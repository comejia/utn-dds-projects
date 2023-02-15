package com.comejia.dds.producto;

import com.comejia.dds.estado_prenda.EstadoPrenda;
import com.comejia.dds.tipo_prenda.TipoPrenda;

public class Prenda {

    private final Double precioBase;
    private EstadoPrenda estadoPrenda;
    private final TipoPrenda tipoPrenda;

    public Prenda(Double precioBase, EstadoPrenda estadoPrenda, TipoPrenda tipoPrenda) {
        this.precioBase = precioBase;
        this.estadoPrenda = estadoPrenda;
        this.tipoPrenda = tipoPrenda;
    }

    public Double precio() {
        return estadoPrenda.precioFinal(precioBase);
    }

    public TipoPrenda tipoDePrenda() {
        return tipoPrenda;
    }

    public void cambiarEstado(EstadoPrenda estadoPrenda) {
        this.estadoPrenda = estadoPrenda;
    }
}
