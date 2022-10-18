package got;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NA")
public class Naval extends FuerzaMilitar {
  private int cantidadBarcos;

  public Naval(int cantidadBarcos) {
    this.cantidadBarcos = cantidadBarcos;
  }

  @Override
  public void atacarA(Lugar lugar) {

  }
}
