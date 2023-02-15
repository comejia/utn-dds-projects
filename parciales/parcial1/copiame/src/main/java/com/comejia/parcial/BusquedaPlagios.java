package com.comejia.parcial;

import java.util.List;

public class BusquedaPlagios implements Servicio {

    private Documento original;
    private List<Documento> posiblesCopias;
    private Calidad calidad;

    public BusquedaPlagios(Documento original, List<Documento> posiblesCopias, Calidad calidad) {

        this.original = original;
        this.posiblesCopias = posiblesCopias;
        this.calidad = calidad;
    }

    @Override
    public void analizarDocumentos() {

        this.calidad.notificar();
    }

    @Override
    public int precio() {
        return (1 + this.posiblesCopias.size()) * calidad.precio();
    }
}
