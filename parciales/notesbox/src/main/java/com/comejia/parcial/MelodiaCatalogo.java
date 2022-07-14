package com.comejia.parcial;

public class MelodiaCatalogo implements Melodia {

    String nombre;
    int precio;
    EstadoValidacion estadoValidacion = EstadoValidacion.ACEPTADA;


    @Override
    public int precio() {
        return this.precio;
    }

    @Override
    public int tiempoEntrega() {
        return 5;
    }

    public EstadoValidacion estado() {
        return this.estadoValidacion;
    }

}
