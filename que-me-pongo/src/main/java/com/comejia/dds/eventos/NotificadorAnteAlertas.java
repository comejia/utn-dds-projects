package com.comejia.dds.eventos;

import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.negocio.Usuario;

import java.util.List;

public class NotificadorAnteAlertas implements AccionConfirgurable {

  @Override
  public void anteNuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas) {
    alertas.forEach(alerta -> new Notificador().notificar(alerta.getMensaje()));
  }
}
