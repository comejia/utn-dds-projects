package com.comejia.parcial;

import java.util.List;

public class Usuario {
    String generoFavorito;

    String directorFavorito;

    Perfil perfil;
    List<Contenido> contenidosVistos;

    public String getGeneroFavorito() {
        return generoFavorito;
    }

    public String getDirectorFavorito() {
        return directorFavorito;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public List<Contenido> getContenidosVistos() {
        return contenidosVistos;
    }
}
