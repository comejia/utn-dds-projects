package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.estado_prenda.Nueva;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VentaTest {

  @Test
  public void elImporteDeUnaVentaEnEfectivoEsSinRecargo() {
    Venta venta = new VentaEnEfectivo(itemsVendidos(), LocalDate.now());

    assertEquals(venta.importe(), 12000, 0);
  }

  @Test
  public void elImporteDeUnaVentaConTarjetaEsConRecargo() {
    Venta venta = new VentaConTarjeta(itemsVendidos(), LocalDate.now(), 3);

    assertEquals(venta.importe(), 12122.4, 0);
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
