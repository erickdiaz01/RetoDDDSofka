package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.Identity;

public class ReferenciaId extends Identity {
    public ReferenciaId(String valor) {
        super(valor);
    }

    public ReferenciaId() {
    }
    public static ReferenciaId of(String valor ){
        return  new ReferenciaId(valor);
    }
}
