package com.comejia.dds.eventos.adapters;

import com.comejia.dds.eventos.extern.NotificationService;

public class ServicioDeNotificaciones implements Notificador {

    private final NotificationService notificationService;

    public ServicioDeNotificaciones(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void notificar(String mensaje) {
        this.notificationService.notify(mensaje);
    }
}
