package got;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FuerzaMilitarTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void setup() {
    super.setup();
  }

  @AfterEach
  public void tearDown() {
    super.tearDown();
  }

  @Test
  public void puedePersistirUnaFuerzaNaval() {
    entityManager().persist(new Naval(20));
  }

  @Test
  public void puedePersistirUnaFuerzaTerrestre() {
    entityManager().persist(new Terrestre(20));
  }

  @Test
  public void puedePersistirUnaFuerzaAerea() {
    entityManager().persist(new Aerea(30));
  }

  @Test
  public void puedeRecuperarFuerzas() {
    entityManager().persist(new Naval(10));
    entityManager().persist(new Terrestre(10));
    entityManager().persist(new Aerea(10));

    withTransaction(() -> { });

    assertEquals(
        3,
        entityManager().createQuery("from FuerzaMilitar", FuerzaMilitar.class).getResultList().size()
    );
  }
}
