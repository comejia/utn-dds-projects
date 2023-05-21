package com.comejia.parcial;

public class ClausulaPrecio implements Clausula {

    public ClausulaPrecio(int deuda, String grano, int precioXTonelada, int toneladaAEntregar) {
        
    }

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
