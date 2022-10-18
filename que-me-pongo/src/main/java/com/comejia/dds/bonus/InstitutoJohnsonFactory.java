package com.comejia.dds.bonus;

import com.comejia.dds.prenda.Borrador;
import com.comejia.dds.prenda.Color;
import com.comejia.dds.prenda.Material;
import com.comejia.dds.prenda.Prenda;
import com.comejia.dds.prenda.TipoDePrenda;
import com.comejia.dds.prenda.Trama;

public class InstitutoJohnsonFactory implements EstablecimientoAbstractFactory {

  @Override
  public Prenda crearParteSuperior() {
    Borrador builder = new Borrador(Trama.LISA);
    return builder.indicarTipoPrenda(TipoDePrenda.CAMISA_MANGA_CORTA)
        .indicarColorPrincipal(new Color())
        .indicarMaterial(Material.ALGODON)
        .build();
  }

  @Override
  public Prenda crearParteInferior() {
    Borrador builder = new Borrador(Trama.LISA);
    return builder.indicarTipoPrenda(TipoDePrenda.PANTALON)
        .indicarColorPrincipal(new Color())
        .indicarMaterial(Material.SEDA)
        .build();
  }

  @Override
  public Prenda crearCalzado() {
    Borrador builder = new Borrador(Trama.LISA);
    return builder.indicarTipoPrenda(TipoDePrenda.ZAPATOS)
        .indicarColorPrincipal(new Color())
        .indicarMaterial(Material.CUERO)
        .build();
  }
}
