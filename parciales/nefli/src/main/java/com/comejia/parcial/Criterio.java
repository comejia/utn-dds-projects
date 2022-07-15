package com.comejia.parcial;

import java.util.List;

public interface Criterio {
    List<Contenido> sugerencias(List<Contenido> contenidos, Usuario usuario);
}
