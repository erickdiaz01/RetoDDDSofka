package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreCompletoCliente implements ValueObject<String> {
    private final String nombreCompletoCliente;

    public NombreCompletoCliente(String nombreCliente, String apellidoCliente) {
        this.nombreCompletoCliente= nombreCliente+" "+apellidoCliente;
    }

    @Override
    public String value() {
        return nombreCompletoCliente;
    }

}
