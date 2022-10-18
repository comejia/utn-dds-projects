package got;

import got.Lugar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class Castillo extends Lugar {
  private int cantidadTorres;
  private int cantidadMurallas;

  public Castillo(String nombre, int anioFundacion, int poblacion, int cantidadTorres, int cantidadMurallas) {
    super(nombre,anioFundacion,poblacion);
    this.cantidadTorres = cantidadTorres;
    this.cantidadMurallas = cantidadMurallas;
  }
}
