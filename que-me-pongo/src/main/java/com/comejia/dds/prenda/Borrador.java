package com.comejia.dds.prenda;

import com.comejia.dds.negocio.PrendaInvalidaException;

public class Borrador {

  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Borrador(Trama tramaDefault) {
    this.trama = tramaDefault;
  }

  public Borrador indicarTipoPrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
    return this;
  }

  public Borrador indicarMaterial(Material material) {
    // El requisito no especifica como validar la consistencia
    /*if (!esMaterialConsistenteConTipoPrenda(material)) {
      throw new PrendaInvalidaException("El material no es consistente");
    }*/
    this.material = material;
    return this;
  }

  public Borrador indicarTrama(Trama trama) {
    this.trama = trama;
    return this;
  }

  public Borrador indicarColorPrincipal(Color color) {
    this.colorPrincipal = color;
    return this;
  }

  public Borrador indicarColorSecundario(Color color) {
    this.colorSecundario = color;
    return this;
  }

  public void validarPrenda() {
    if (tipoDePrenda == null) {
      throw new PrendaInvalidaException("Tipo de prenda no valido");
    }
    if (material == null) {
      throw new PrendaInvalidaException("Material no valido");
    }
    if (trama == null) {
      throw new PrendaInvalidaException("Trama no valido");
    }
    if (colorPrincipal == null) {
      throw new PrendaInvalidaException("Color no valido");
    }
  }

  public Prenda build() {
    validarPrenda();
    return new Prenda(this.tipoDePrenda, this.material, this.trama,
        this.colorPrincipal, this.colorSecundario);
  }

}
