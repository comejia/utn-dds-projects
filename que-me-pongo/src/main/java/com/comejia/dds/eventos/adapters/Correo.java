package com.comejia.dds.eventos.adapters;

import com.comejia.dds.negocio.Usuario;

public interface Correo {
  void enviarCorreo(Usuario usuario, String cuerpo);
}
