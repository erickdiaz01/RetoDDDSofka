package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class DireccionSede implements ValueObject<String> {
    private final String direccionSede;

    public DireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    @Override
    public String value() {
        return direccionSede;
    }
}
