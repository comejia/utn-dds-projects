package com.comejia.dds.negocio;

import com.comejia.dds.atuendos.Guardarropas;
import com.comejia.dds.atuendos.Sugerencia;
import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.eventos.AccionConfirgurable;
import com.comejia.dds.prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

  private final List<Guardarropas> guardarropas;
  private Sugerencia sugerenciaDiaria;
  List<AccionConfirgurable> accionConfirgurables = new ArrayList<>();

  public Usuario(List<Guardarropas> guardarropas) {
    this.guardarropas = guardarropas;
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  public void quitarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.remove(guardarropas);
  }

  public Guardarropas crearGuardarropas(List<Prenda> prendas) {
    Guardarropas guardarropas = new Guardarropas(prendas);
    this.guardarropas.add(guardarropas);
    return guardarropas;
  }

  public Sugerencia getSugerenciaDiaria() {
    return this.sugerenciaDiaria;
  }

  public Sugerencia calcularSugerencia() {
    return new Sugerencia();
  }

  public void agregarAccion(AccionConfirgurable accion) {
    this.accionConfirgurables.add(accion);
  }

  public void removerAccion(AccionConfirgurable accion) {
    this.accionConfirgurables.remove(accion);
  }

  public void calcularSugerenciaDiaria() {
    this.sugerenciaDiaria = calcularSugerencia();
  }

  public void realizarAccionSobreAlertas(List<AlertaMeteorologica> alertas) {
    this.accionConfirgurables.forEach(accion -> accion.anteNuevasAlertasMeteorologicas(this, alertas));
  }

}
