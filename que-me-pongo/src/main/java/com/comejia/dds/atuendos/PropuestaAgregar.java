package com.comejia.dds.atuendos;

import com.comejia.dds.prenda.Prenda;

public class PropuestaAgregar extends Propuesta {

  public PropuestaAgregar(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void realizarModificacion(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(this.prenda);
  }

  @Override
  public void deshacerModificacion(Guardarropas guardarropas) {
    guardarropas.quitarPrenda(this.prenda);
  }

}
