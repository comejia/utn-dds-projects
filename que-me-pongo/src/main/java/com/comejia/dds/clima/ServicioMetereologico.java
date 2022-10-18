package com.comejia.dds.clima;

import java.util.List;

public interface ServicioMetereologico {

  CondicionClimatica obtenerCondicionClimatica(String ciudad);

  List<AlertaMeteorologica> getAlertasMeteorlogicas();

}
