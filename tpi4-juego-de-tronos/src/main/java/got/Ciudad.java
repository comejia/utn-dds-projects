package got;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CI")
public class Ciudad extends Lugar {
  private int cantidadDeComercios;
  private int cantidadDeSantuarios;
  private double tasaDeMortalidad;

  public Ciudad(String nombre, int anioFundacion, int poblacion, int cantidadDeComercios, int cantidadDeSantuarios, double tasaDeMortalidad) {
    super(nombre, anioFundacion, poblacion);
    this.cantidadDeComercios = cantidadDeComercios;
    this.cantidadDeSantuarios = cantidadDeSantuarios;
    this.tasaDeMortalidad = tasaDeMortalidad;
  }
}
