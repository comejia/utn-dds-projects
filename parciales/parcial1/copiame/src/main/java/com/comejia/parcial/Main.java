package com.comejia.parcial;

public class Main {
    public static void main(String[] args) {
        RepositorioServicios.getInstance().getServicios().forEach(Servicio::analizarDocumentos);
    }
}
