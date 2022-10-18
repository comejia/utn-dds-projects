package com.comejia.dds.atuendos;

import com.comejia.dds.clima.CondicionClimatica;
import com.comejia.dds.clima.ServicioMetereologico;
import com.comejia.dds.negocio.RepositorioUsuarios;
import com.comejia.dds.negocio.Usuario;

import java.util.List;

public class SeleccionadorDeAtuendo {

  private RepositorioUsuarios repositorioUsuarios;
  private final ServicioMetereologico servicioMetereologico;

  public SeleccionadorDeAtuendo(ServicioMetereologico servicioMetereologico) {
    this.servicioMetereologico = servicioMetereologico;
  }

  public Atuendo sugerirAtuendo(Guardarropas guardarropas, String ciudad) {
    List<Atuendo> atuendos = guardarropas.generarAtuendos();
    CondicionClimatica condicionClimatica = this.servicioMetereologico.obtenerCondicionClimatica(ciudad);

    return atuendos.stream()
        .filter(atuendo -> atuendo.esAptoParaTemperatura(condicionClimatica.getTemperatura()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No se encontro atuendos acorde a la temperatura de la ciudad"));
  }

  public void calcularSugerenciasDiarias() {
    repositorioUsuarios.getUsuarios().forEach(Usuario::calcularSugerenciaDiaria);
  }
}
