package got;

import javax.persistence.*;

@Entity
@Table(name = "FuerzasMilitares")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "fuerza", length = 2)
abstract class FuerzaMilitar extends EntityPersistence {
  abstract void atacarA(Lugar lugar);
}
