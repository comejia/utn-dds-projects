package com.comejia.dds.eventos;

import com.comejia.dds.clima.AlertaMeteorologica;
import com.comejia.dds.eventos.adapters.Notificador;
import com.comejia.dds.negocio.Usuario;

import java.util.List;

public class NotificadorAnteAlertas implements AccionConfigurable {

    Notificador notificador;

    @Override
    public void anteNuevasAlertasMeteorologicas(Usuario usuario, List<AlertaMeteorologica> alertas) {
        alertas.forEach(alerta -> this.notificador.notificar(alerta.getMensaje()));
    }
}
