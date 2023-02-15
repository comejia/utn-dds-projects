package com.comejia.dds.eventos.adapters;

import com.comejia.dds.eventos.extern.MailSender;
import com.comejia.dds.negocio.Usuario;

public class CorreoMailSender implements Correo {

    MailSender mailSender;

    public CorreoMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviarCorreo(Usuario usuario, String cuerpo) {
        //this.mailSender.send(usuario.direccion, cuerpo);
    }
}
