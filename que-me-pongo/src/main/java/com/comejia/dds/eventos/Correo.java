package com.comejia.dds.eventos;

import com.comejia.dds.negocio.Usuario;

public interface Correo {
  void enviarCorreo(Usuario usuario, String mensaje);
}
