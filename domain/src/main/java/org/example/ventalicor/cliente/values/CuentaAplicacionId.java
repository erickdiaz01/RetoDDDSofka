package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaAplicacionId extends Identity {
    public CuentaAplicacionId(String value) {
        super(value);
    }

    public CuentaAplicacionId() {
    }

    public static CuentaAplicacionId of(String s) {
        return  new CuentaAplicacionId(s);
    }
}
