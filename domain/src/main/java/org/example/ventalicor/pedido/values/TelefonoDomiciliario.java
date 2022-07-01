package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class TelefonoDomiciliario implements ValueObject<String> {
    private final String telefonoDomiciliario;

    public TelefonoDomiciliario(String telefonoDomiciliario) {
        this.telefonoDomiciliario = telefonoDomiciliario;
    }

    @Override
    public String value() {
        return telefonoDomiciliario;
    }
    public TelefonoDomiciliario cambiarTelefono(String telefono){
        return new TelefonoDomiciliario(telefono);
    }
}
