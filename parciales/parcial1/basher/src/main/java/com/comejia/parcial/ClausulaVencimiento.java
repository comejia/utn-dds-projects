package com.comejia.parcial;

import java.time.LocalDateTime;

public class ClausulaVencimiento implements Clausula {

    LocalDateTime fechaVencimiento;

    @Override
    public String texto() {
        return "Vence el " + this.fechaVencimiento;
    }
}
