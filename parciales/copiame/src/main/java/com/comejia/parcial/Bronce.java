package com.comejia.parcial;

import java.util.List;

public class Bronce implements Calidad {
    @Override
    public void notificar(Revisor revisor, List<Documento> documentos) {

    }

    @Override
    public int precio() {
        return 100;
    }
}
