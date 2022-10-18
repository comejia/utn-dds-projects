package com.comejia.dds.atuendos;

import com.comejia.dds.prenda.Prenda;

public class Atuendo {

  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda calzado;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  public boolean esAptoParaTemperatura(int temperatura) {
    return this.prendaSuperior.aptaParaTemperatura(temperatura) &&
        this.prendaInferior.aptaParaTemperatura(temperatura) &&
        this.calzado.aptaParaTemperatura(temperatura);
  }
}