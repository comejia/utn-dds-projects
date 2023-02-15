package com.comejia.parcial;

import java.util.List;

public class RepositorioClientes {
    List<Cliente> clientes;

    public void registrar(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
