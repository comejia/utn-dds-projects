package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.estado_prenda.Nueva;
import ar.edu.utn.frba.dds.macowins.negocio.TiendaDeRopa;
import ar.edu.utn.frba.dds.macowins.producto.Item;
import ar.edu.utn.frba.dds.macowins.producto.Prenda;
import ar.edu.utn.frba.dds.macowins.tipo_prenda.TipoPrenda;
import ar.edu.utn.frba.dds.macowins.venta.Venta;
import ar.edu.utn.frba.dds.macowins.venta.VentaConTarjeta;
import ar.edu.utn.frba.dds.macowins.venta.VentaEnEfectivo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TiendaTest {

  @Test
  public void laGananciaDeUnDiaEsLaSumaDeLaVentasRealizadasEseDia() {
    TiendaDeRopa tienda = new TiendaDeRopa();
    tienda.registrarVenta(ventaRealizadaEl(LocalDate.now()));
    tienda.registrarVenta(ventaRealizadaEl(LocalDate.now()));
    tienda.registrarVenta(ventaRealizadaEl(LocalDate.now().minusDays(3)));

    assertEquals(tienda.gananciaDeUnDia(LocalDate.now()), 24000);
  }

  private Venta ventaRealizadaEl(LocalDate date) {
    return new VentaEnEfectivo(itemsVendidos(), date);
  }

  private List<Item> itemsVendidos() {
    List<Item> items = new ArrayList<>();
    items.add(itemConVariasPrendas());
    return items;
  }

  private Item itemConVariasPrendas() {
    return new Item(camisaNueva(4000), 3);
  }

  private Prenda camisaNueva(double precioBase) {
    return new Prenda(precioBase, new Nueva(), TipoPrenda.CAMISA);
  }
}
