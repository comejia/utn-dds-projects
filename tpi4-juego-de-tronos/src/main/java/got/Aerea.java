package got;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AE")
public class Aerea extends FuerzaMilitar {
  private int cantidadDragones;

  public Aerea(int cantidadDragones) {
    this.cantidadDragones = cantidadDragones;
  }

  @Override
  public void atacarA(Lugar lugar) {
  }
}
