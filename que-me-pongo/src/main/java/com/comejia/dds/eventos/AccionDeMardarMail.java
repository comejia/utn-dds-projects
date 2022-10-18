package com.comejia.dds.eventos;

import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.negocio.Usuario;

import java.util.List;

public class AccionDeMardarMail implements AccionConfirgurable {

  private Correo correo;

  @Override
  public void anteNuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas) {
    this.correo.enviarCorreo(usuario, "Hay nuevas alertas!");
  }
}
