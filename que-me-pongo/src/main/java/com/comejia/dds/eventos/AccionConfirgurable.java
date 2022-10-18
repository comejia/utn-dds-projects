package com.comejia.dds.eventos;

import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.negocio.Usuario;

import java.util.List;

public interface AccionConfirgurable {
  void anteNuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas);
}
