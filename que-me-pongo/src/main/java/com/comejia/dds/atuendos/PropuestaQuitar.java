package com.comejia.dds.atuendos;

import com.comejia.dds.prenda.Prenda;

public class PropuestaQuitar extends Propuesta {

  public PropuestaQuitar(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void realizarModificacion(Guardarropas guardarropas) {
    guardarropas.quitarPrenda(this.prenda);
  }

  @Override
  public void deshacerModificacion(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(this.prenda);
  }

}
