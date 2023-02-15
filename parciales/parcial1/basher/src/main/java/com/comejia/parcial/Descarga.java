package com.comejia.parcial;

import java.util.List;

public class Descarga {

    private Cliente cliente;
    private TipoGrano tipoGrano;

    private int cantidad;
    private Contrato contrato;

    public Descarga(Cliente cliente, TipoGrano tipoGrano, int cantidad) {

        this.cliente = cliente;
        this.tipoGrano = tipoGrano;
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoGrano getTipoGrano() {
        return tipoGrano;
    }

    public void agregarContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public void liquidar() {
        int precio = cantidad * contrato.precioContrato();
        registrarEnAFIP(precio);
        registrarEnSAP(precio);
    }

    private void registrarEnSAP(int precio) {

    }

    private void registrarEnAFIP(int precio) {


    }
}
