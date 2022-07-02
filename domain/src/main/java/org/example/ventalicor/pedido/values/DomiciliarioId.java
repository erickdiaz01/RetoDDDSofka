package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class DomiciliarioId extends Identity {
    public DomiciliarioId(String valor) {
        super(valor);
    }

    public DomiciliarioId() {
    }

    public static DomiciliarioId of(String s) {
        return  new DomiciliarioId(s);
    }
}
