package com.comejia.dds.bonus;

import com.comejia.dds.prenda.Prenda;

public interface EstablecimientoAbstractFactory {
  Prenda crearParteSuperior();

  Prenda crearParteInferior();

  Prenda crearCalzado();
}
