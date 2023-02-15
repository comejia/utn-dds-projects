package com.comejia.dds.producto;

public class Item {
    private final Prenda prenda;
    private final Double cantidad;

    public Item(Prenda prenda, Double cantidad) {
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    public Double importe() {
        return this.prenda.precio() * this.cantidad;
    }
}
