package ar.edu.utn.frba.dds.macowins.producto;

public class Item {
  private final Prenda prenda;
  private final Integer cantidad;

  public Item(Prenda prenda, Integer cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public Double importe() {
    return this.prenda.precio() * this.cantidad;
  }
}
