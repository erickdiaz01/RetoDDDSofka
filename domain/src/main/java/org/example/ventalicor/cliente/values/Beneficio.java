package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class Beneficio implements ValueObject<String> {
    private final String beneficio;

    public Beneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public String value() {
        return beneficio;
    }
}
