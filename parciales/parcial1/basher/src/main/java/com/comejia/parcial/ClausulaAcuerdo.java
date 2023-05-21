package com.comejia.parcial;

public class ClausulaAcuerdo implements Clausula {
    @Override
    public String texto() {
        return "";
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
