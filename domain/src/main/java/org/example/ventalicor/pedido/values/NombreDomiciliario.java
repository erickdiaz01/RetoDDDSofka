package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreDomiciliario implements ValueObject<String> {
    private final String nombreDomiciliario;

    public NombreDomiciliario(String nombreDomiciliario) {
        this.nombreDomiciliario = nombreDomiciliario;
    }

    @Override
    public String value() {
        return nombreDomiciliario;
    }

}
