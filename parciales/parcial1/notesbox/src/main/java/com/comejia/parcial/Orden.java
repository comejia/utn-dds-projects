package com.comejia.parcial;

import java.time.LocalDateTime;

public class Orden {

    EstadoOrden estadoOrden;
    private Melodia melodia;
    private Cliente cliente;
    private Fabrica fabrica;
    private Notificador notificador;
    private LocalDateTime fecha;

    // Requerimiento 2
    public Orden(Melodia melodia, Cliente cliente) {
        this.melodia = melodia;
        this.cliente = cliente;
        this.estadoOrden = EstadoOrden.PEDIDA;
    }

    // Requerimiento 3
    public EstadoOrden getEstado() {
        return this.estadoOrden;
    }

    public int tiempoDeEntrega() {
        return this.estadoOrden.tiempoEstimado(fabrica) + melodia.tiempoEntrega();
    }

    public String getDireccionEnvio() {
        return this.cliente.getDireccionEnvio();
    }

    public boolean pendiente() {
        return this.estadoOrden == EstadoOrden.PENDIENTE;
    }

    public int precio() {
        return this.melodia.precio();
    }

    public void asignar(Fabrica fabrica) {
        this.fabrica = fabrica;
        this.estadoOrden = EstadoOrden.ASIGNADA;
    }

    public boolean estaEnPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        return this.fecha.isAfter(inicio) && this.fecha.isBefore(fin);
    }
}
