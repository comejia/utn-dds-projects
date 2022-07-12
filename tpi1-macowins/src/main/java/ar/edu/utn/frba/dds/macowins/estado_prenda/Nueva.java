package ar.edu.utn.frba.dds.macowins.estado_prenda;

public class Nueva implements EstadoPrenda {

  @Override
  public Double precioFinal(Double precioBase) {
    return precioBase;
  }
}
