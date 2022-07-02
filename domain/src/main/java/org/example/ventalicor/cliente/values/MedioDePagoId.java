package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class MedioDePagoId extends Identity {
    public MedioDePagoId(String valor) {
        super(valor);
    }

    public MedioDePagoId() {
    }

    public static MedioDePagoId of(String s) {
        return new MedioDePagoId(s);
    }
}
