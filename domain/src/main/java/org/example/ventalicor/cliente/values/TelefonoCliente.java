package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class TelefonoCliente implements ValueObject<String> {
 private final String telefonoCliente;

    public TelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Override
    public String value() {
        return telefonoCliente;
    }

    public TelefonoCliente cambiarTelefono(String telefono){
        return new TelefonoCliente(telefono);
    }

}
