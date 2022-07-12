package ar.edu.utn.frba.dds.macowins.venta;

import ar.edu.utn.frba.dds.macowins.producto.Item;

import java.time.LocalDate;
import java.util.List;

public class VentaEnEfectivo extends Venta {

  public VentaEnEfectivo(List<Item> items, LocalDate fecha) {
      super(items, fecha);
  }

  @Override
  public Double recargo(Double importeBase) {
      return 0.0;
  }
}
