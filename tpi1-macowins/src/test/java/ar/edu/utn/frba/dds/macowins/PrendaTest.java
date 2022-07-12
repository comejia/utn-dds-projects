package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.estado_prenda.Liquidacion;
import ar.edu.utn.frba.dds.macowins.estado_prenda.Nueva;
import ar.edu.utn.frba.dds.macowins.estado_prenda.Promocion;
import ar.edu.utn.frba.dds.macowins.producto.Prenda;
import ar.edu.utn.frba.dds.macowins.tipo_prenda.TipoPrenda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @Test
  public void elTipoDeUnPantalonEnPromocionEsPANTALON() {
    assertEquals(pantalonEnPromocion(200, 50).getTipo().toString(), "PANTALON");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }


  private Prenda pantalonEnPromocion(double precioBase, double descuento) {
    return new Prenda(precioBase, new Promocion(descuento), TipoPrenda.PANTALON);
  }

  private Prenda camisaNueva(double precioBase) {
    return new Prenda(precioBase, new Nueva(), TipoPrenda.CAMISA);
  }

  private Prenda sacoEnLiquidacion(double precioBase) {
    return new Prenda(precioBase, new Liquidacion(), TipoPrenda.SACO);
  }
}
