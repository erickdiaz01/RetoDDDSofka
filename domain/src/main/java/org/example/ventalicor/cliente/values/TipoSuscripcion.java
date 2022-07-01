package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class TipoSuscripcion implements ValueObject<String> {
    private final tipo tipoSuscripcion;

    public TipoSuscripcion(tipo tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    @Override
    public String value() {
        return String.valueOf(tipoSuscripcion);
    }
    public enum tipo {PREMIUM,ESTANDAR,GOLD}

    public TipoSuscripcion cambiarTipo (tipo tipoSuscripcion){
        return new TipoSuscripcion(tipoSuscripcion);
    }
}
