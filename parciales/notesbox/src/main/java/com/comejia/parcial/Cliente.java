package com.comejia.parcial;

public class Cliente {

    private String nombre;
    private String apellido;
    private String email;
    private String direccionEnvio;

    public Cliente(String nombre, String apellido, String email, String direccionEnvio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccionEnvio = direccionEnvio;
    }

    public String getDireccionEnvio() {
        return this.direccionEnvio;
    }
}
