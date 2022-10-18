package got;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class RegionTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void setup() {
    super.setup();
  }

  @AfterEach
  public void tearDown() {
    super.tearDown();
  }

  @Test
  public void puedePersistirUnaRegion() {
    Lugar winterfell = new Castillo("Mordor", 100, 1000, 20, 5);
    Casa stark = new Casa("Stark", 100000, 100, new Casa(), Collections.singletonList(new Aerea(10)), winterfell);

    Region region = new Region("El norte", stark, Arrays.asList(winterfell));
    entityManager().persist(region);
  }
}
