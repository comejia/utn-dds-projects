package ar.edu.utn.frba.dds.macowins.estado_prenda;

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
