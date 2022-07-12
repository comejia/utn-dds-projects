package ar.edu.utn.frba.dds.macowins.producto;

import ar.edu.utn.frba.dds.macowins.estado_prenda.EstadoPrenda;
import ar.edu.utn.frba.dds.macowins.tipo_prenda.TipoPrenda;

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

  public TipoPrenda getTipo() {
    return tipoPrenda;
  }

  public void cambiarEstado(EstadoPrenda estadoPrenda) {
    this.estadoPrenda = estadoPrenda;
  }
}
