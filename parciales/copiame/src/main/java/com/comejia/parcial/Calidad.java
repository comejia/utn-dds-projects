package com.comejia.parcial;

import java.util.List;

public interface Calidad {

    void notificar(Revisor revisor, List<Documento> documentos);

    int precio();
}
