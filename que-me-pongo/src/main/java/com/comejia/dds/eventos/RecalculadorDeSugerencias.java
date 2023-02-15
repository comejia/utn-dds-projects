package com.comejia.dds.eventos;

import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.negocio.Usuario;

import java.util.List;

public class RecalculadorDeSugerencias implements AccionConfigurable {
    @Override
    public void anteNuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas) {
        usuario.calcularSugerenciaDiaria();
    }
}
