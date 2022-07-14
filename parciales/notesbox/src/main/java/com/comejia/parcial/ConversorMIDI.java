package com.comejia.parcial;

public class ConversorMIDI implements Conversor {

    MIDIConverter midiConverter;

    @Override
    public String convertir(byte[] audio) {
        return this.midiConverter.convert(audio);
    }
}
