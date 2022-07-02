package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class SedeId extends Identity {
    public SedeId(String valor) {
        super(valor);
    }

    public SedeId() {
    }
    public static SedeId of(String valor){
        return new SedeId(valor);
    }
}
