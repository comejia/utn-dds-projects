package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.estado_prenda.Nueva;
import ar.edu.utn.frba.dds.macowins.producto.Item;
import ar.edu.utn.frba.dds.macowins.producto.Prenda;
import ar.edu.utn.frba.dds.macowins.tipo_prenda.TipoPrenda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

  @Test
  public void elImporteDeUnItemEsElPrecioDeLaPrendaPorLaCantidadVendida() {
    Prenda prenda = camisaNueva(4000);
    Integer cantidad = 3;
    Item item = new Item(prenda, cantidad);

    assertEquals(prenda.precio() * cantidad, item.importe(), 0);
  }

  private Prenda camisaNueva(double precioBase) {
    return new Prenda(precioBase, new Nueva(), TipoPrenda.CAMISA);
  }
}
