package com.comejia.dds.atuendos;

import com.comejia.dds.prenda.Prenda;

public abstract class Propuesta {

  protected EstadoPropuesta estadoPropuesta;
  protected Prenda prenda;

  public Propuesta(Prenda prenda) {
    this.estadoPropuesta = EstadoPropuesta.PENDIENTE;
    this.prenda = prenda;
  }

  public void aceptar(Guardarropas guardarropas) {
    this.estadoPropuesta = EstadoPropuesta.ACEPTADO;
    realizarModificacion(guardarropas);
  }

  public void rechazar() {
    this.estadoPropuesta = EstadoPropuesta.RECHAZADO;
  }

  public void deshacer(Guardarropas guardarropas) {
    this.estadoPropuesta = EstadoPropuesta.RECHAZADO;
    deshacerModificacion(guardarropas);
  }

  public abstract void realizarModificacion(Guardarropas guardarropas);

  public abstract void deshacerModificacion(Guardarropas guardarropas);

  public boolean estaPendiente() {
    return this.estadoPropuesta == EstadoPropuesta.PENDIENTE;
  }

  public boolean estaAceptada() {
    return this.estadoPropuesta == EstadoPropuesta.ACEPTADO;
  }
}
