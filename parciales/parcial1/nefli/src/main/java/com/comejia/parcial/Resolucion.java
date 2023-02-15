package com.comejia.parcial;

public enum Resolucion {
    _240PX(240),
    _720PX(720),
    _1080PX(1080);

    private int resolucion;

    public Resolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public int getResolucion() {
        return this.resolucion;
    }
}
