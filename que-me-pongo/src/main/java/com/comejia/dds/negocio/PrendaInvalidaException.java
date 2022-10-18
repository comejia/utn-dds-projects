package com.comejia.dds.negocio;

public class PrendaInvalidaException extends RuntimeException {
  public PrendaInvalidaException(String message) {
    super("Prenda invalida porque: " + message);
  }
}
