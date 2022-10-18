package com.comejia.dds.clima;

import com.comejia.dds.negocio.RepositorioUsuarios;

import java.util.ArrayList;
import java.util.List;

public class RegistroAlertas {

  List<AlertaMeteorologica> alertas = new ArrayList<>();
  RepositorioUsuarios repositorioUsuarios;

  public void actualizarAlertas(ServicioMetereologico servicioMetereologico) {
    this.alertas = servicioMetereologico.getAlertasMeteorlogicas();
    realizarAccionesSobreAlertas(this.alertas);
  }

  public void realizarAccionesSobreAlertas(List<AlertaMeteorologica> alertas) {
    this.repositorioUsuarios.getUsuarios().forEach(usuario -> usuario.realizarAccionSobreAlertas(alertas));
  }
}
