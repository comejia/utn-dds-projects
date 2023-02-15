package com.comejia.dds.venta;

import com.comejia.dds.producto.Item;

import java.util.Date;
import java.util.List;

public abstract class Venta {
    private final List<Item> items;
    private final Date fecha;

    public Venta(List<Item> items, Date fecha) {
        this.items = items;
        this.fecha = fecha;
    }

    public abstract Double recargo(Double importeBase); // es lo mismo si en vez de pasar "importeBase" las subclases acceden a precioDeItems()

    public Double importe() {
        Double importeBase = precioDeItems();
        return importeBase + recargo(importeBase);
    }

    public Double precioDeItems() {
        return this.items.stream().mapToDouble(Item::importe).sum();
    }

    public boolean esDeFecha(Date fecha) {
        return this.fecha.equals(fecha);
    }
}
