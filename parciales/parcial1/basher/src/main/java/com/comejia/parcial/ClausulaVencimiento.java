package com.comejia.parcial;

import java.time.LocalDateTime;

public class ClausulaVencimiento implements Clausula {

    LocalDateTime fechaVencimiento;

    @Override
    public String texto() {
        return "Vence el " + this.fechaVencimiento;
    }

    @Override
    public Cliente getClient() {
        return null;
    }

    @Override
    public TipoGrano getTipoGrano() {
        return null;
    }

    @Override
    public int precio() {
        return 0;
    }
}
