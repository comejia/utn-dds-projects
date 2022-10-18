package got;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Lugares")
public class Lugar extends EntityPersistence {
  private String nombre;
  private int anioFundacion;
  private int poblacion;

  public Lugar(String nombre, int anioFundacion, int poblacion) {
    this.nombre = nombre;
    this.anioFundacion = anioFundacion;
    this.poblacion = poblacion;
  }

  public String getNombre() {
    return nombre;
  }

}
