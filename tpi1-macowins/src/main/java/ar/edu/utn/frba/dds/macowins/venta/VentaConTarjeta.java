package ar.edu.utn.frba.dds.macowins.venta;

import ar.edu.utn.frba.dds.macowins.producto.Item;

import java.time.LocalDate;
import java.util.List;

public class VentaConTarjeta extends Venta {

  private final Integer cantidadCuotas;
  private final Double coeficienteTarjeta = 0.8;

  public VentaConTarjeta(List<Item> items, LocalDate fecha, Integer cuotas) {
    super(items, fecha);
    this.cantidadCuotas = cuotas;
  }

  @Override
  public Double recargo(Double importeBase) {
    return this.cantidadCuotas * this.coeficienteTarjeta + 0.01 * importeBase;
  }
}
