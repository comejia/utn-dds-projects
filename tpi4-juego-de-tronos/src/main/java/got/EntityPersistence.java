package got;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityPersistence {
  @Id
  @GeneratedValue
  private int id;

  public int getId() {
    return id;
  }
}
