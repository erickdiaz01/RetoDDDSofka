package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(String value) {
        super(value);
    }

    public ClienteId() {
    }

    public static ClienteId of(String valor) {
    return new ClienteId(valor);
    }
}
