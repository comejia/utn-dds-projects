package ar.edu.utn.frba.dds.macowins.tipo_prenda;

public enum TipoPrenda {
  SACO("SACO"),
  PANTALON("PANTALON"),
  CAMISA("CAMISA");

  private final String tipo;

  TipoPrenda(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return tipo;
  }
}
