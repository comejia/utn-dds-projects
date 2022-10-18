package got;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Casas")
public class Casa extends EntityPersistence {
  private String nombre;
  private int patrimonio;
  private int anioFundacion;

  @ManyToOne(cascade = CascadeType.ALL)
  private Casa vasallaDe;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "casa_id")
  private Collection<FuerzaMilitar> fuerzasMilitares;

  @ManyToOne(cascade = CascadeType.ALL)
  private Lugar origen;

  public Casa(String nombre, int patrimonio, int anioFundacion, Casa vasallaDe, Collection<FuerzaMilitar> fuerzasMilitares, Lugar origen) {
    this.nombre = nombre;
    this.patrimonio = patrimonio;
    this.anioFundacion = anioFundacion;
    this.vasallaDe = vasallaDe;
    this.fuerzasMilitares = fuerzasMilitares;
    this.origen = origen;
  }

  public Casa() {

  }

  public String nombreLugarOrigen() {
    return origen.getNombre();
  }
}
