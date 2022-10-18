import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.clima.CondicionClimatica;
import com.comejia.dds.clima.ServicioMetereologico;

import java.util.List;

public class ServicioMetereologicoMock implements ServicioMetereologico {
  @Override
  public CondicionClimatica obtenerCondicionClimatica(String ciudad) {
    return new CondicionClimatica(10, 30);
  }

  @Override
  public List<AlertaMeteorologica> getAlertasMeteorlogicas() {
    return null;
  }

}
