package com.comejia.dds.clima;

public class CondicionClimatica {

  int probabilidadDePrecipitacion;
  int temperatura;

  public CondicionClimatica(int probabilidadDePrecipitacion, int temperatura) {
    this.probabilidadDePrecipitacion = probabilidadDePrecipitacion;
    this.temperatura = temperatura;
  }

  public int getProbabilidadDePrecipitacion() {
    return probabilidadDePrecipitacion;
  }

  public int getTemperatura() {
    return temperatura;
  }

}
