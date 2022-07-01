package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class DirecionCliente implements ValueObject<String> {
    private final String direccionCliente;

    public DirecionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    @Override
    public String value() {
        return direccionCliente;
    }
    public DirecionCliente cambiarDireccion(String direccion){
        return new DirecionCliente(direccion);
    }
}
