package com.comejia.parcial;

public class Cierre implements Cambio {
    @Override
    public void aplicarEn(Grupo grupo) {
        grupo.efectivizarCierre();
    }
}
