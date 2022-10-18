package got;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import static org.junit.jupiter.api.Assertions.*;

public class LugarTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void setup() {
    super.setup();
  }

  @AfterEach
  public void tearDown() {
    super.tearDown();
  }

  @Test
  public void puedePersistirUnCastillo() {
    entityManager().persist(new Castillo("Mordor",100,1000,20, 5));
  }

  @Test
  public void puedePersistirUnaCiudad() {
    entityManager().persist(new Ciudad("tandil",1200,50000,50,15,1.5));
  }

  @Test
  public void puedeRecuperarLugares() {
    entityManager().persist(new Castillo("Mordor",100,1000,20, 5));
    entityManager().persist(new Ciudad("tandil",1200,50000,50,15,1.5));

    withTransaction(() -> {});
    assertEquals(2, entityManager().createQuery("from Lugar", Lugar.class).getResultList().size());
  }
}
