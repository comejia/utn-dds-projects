package com.comejia.parcial;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class Contrato {
    List<Clausula> clausulas;

    public Contrato(List<Clausula> clausulas) {
        this.clausulas = clausulas;
    }

    public String textoAImprimir() {
        String paraImprimir = null;
        this.clausulas.forEach(c -> paraImprimir += c.texto());
        return paraImprimir;
    }

    public boolean mismoCliente(Cliente cliente) {
        return this.clausulas.stream().anyMatch(c -> c.getClient().equals(cliente));
    }

    public boolean esCompatible(Cliente cliente, TipoGrano tipoGrano) {
        return mismoCliente(cliente) && mismoTipoGrano(tipoGrano);
    }

    private boolean mismoTipoGrano(TipoGrano tipoGrano) {
        return this.clausulas.stream().anyMatch(c -> c.getTipoGrano() == tipoGrano);
    }

    public boolean esPrioritario() {
        return this.clausulas.stream().sorted((c, d) -> c.texto().length() < d.texto().length());
    }

    public LocalDateTime fechaVencimiento() {

    }

    public int precioContrato() {
        return clausulas.stream().mapToInt(Clausula::precio).sum();
    }
}
