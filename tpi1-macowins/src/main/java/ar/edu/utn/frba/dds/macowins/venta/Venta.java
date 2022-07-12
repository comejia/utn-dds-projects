package ar.edu.utn.frba.dds.macowins.venta;

import ar.edu.utn.frba.dds.macowins.producto.Item;

import java.time.LocalDate;
import java.util.List;

public abstract class Venta {
  private final List<Item> items;
  private final LocalDate fecha;

  public Venta(List<Item> items, LocalDate fecha) {
    this.items = items;
    this.fecha = fecha;
  }

  public abstract Double recargo(Double importeBase);

  public Double importe() {
    Double importeBase = precioDeItems();
    return importeBase + recargo(importeBase);
  }

  private Double precioDeItems() {
    return this.items.stream().mapToDouble(Item::importe).sum();
  }

  public boolean esDeFecha(LocalDate fecha) {
    return this.fecha.equals(fecha);
  }
}
