package com.comejia.parcial;

public interface Clausula {
    String texto();

    Cliente getClient();

    TipoGrano getTipoGrano();

    int precio();
}
