package com.comejia.parcial;

import java.util.List;

public interface SCM {
    void crearRepositorio(String nombreRepo, List<String> usuarios);
    void darAcceso(String nombreRepo, String usuario);
    void quitarAcceso(String nombreRepo, String usuario);
}
