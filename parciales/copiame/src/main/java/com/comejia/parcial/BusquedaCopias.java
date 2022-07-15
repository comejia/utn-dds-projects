package com.comejia.parcial;

import java.util.List;

public class BusquedaCopias implements Servicio {

    private List<Documento> documentos;
    private Calidad calidad;

    public BusquedaCopias(List<Documento> documentos, Calidad calidad) {

        this.documentos = documentos;
        this.calidad = calidad;
    }

    @Override
    public void analizarDocumentos() {

    }

    @Override
    public int precio() {
        return this.documentos.size() * calidad.precio();
    }

}
