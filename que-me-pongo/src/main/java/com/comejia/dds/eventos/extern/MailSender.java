package com.comejia.dds.eventos.extern;

public interface MailSender {

    void send(String address, String message);
}
