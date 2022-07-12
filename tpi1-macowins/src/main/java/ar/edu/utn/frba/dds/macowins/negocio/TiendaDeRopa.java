package ar.edu.utn.frba.dds.macowins.negocio;

import ar.edu.utn.frba.dds.macowins.venta.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TiendaDeRopa {

  private final List<Venta> ventas = new ArrayList<>();

  public void registrarVenta(Venta venta) {
    this.ventas.add(venta);
  }

  public Double gananciaDeUnDia(LocalDate fecha) {
    return ventasDeUnDia(fecha)
        .stream()
        .mapToDouble(Venta::importe)
        .sum();
  }

  private List<Venta> ventasDeUnDia(LocalDate fecha) {
    return this.ventas.stream()
        .filter(venta -> venta.esDeFecha(fecha))
        .collect(Collectors.toList());
  }
}
