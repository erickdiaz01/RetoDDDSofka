package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class TipoMedioDePago implements ValueObject<String> {
    private final tipoMedioDePago tipoMedioDePago;



    public TipoMedioDePago(TipoMedioDePago.tipoMedioDePago tipoMedioDePago) {
        this.tipoMedioDePago = tipoMedioDePago;
    }

    @Override
    public String value() {
        return String.valueOf(tipoMedioDePago);
    }

    public TipoMedioDePago.tipoMedioDePago getTipoMedioDePago() {
        return tipoMedioDePago;
    }

    public enum tipoMedioDePago{EFECTIVO,TARJETACREDITO,TARJETADEBITO,PSE};
}
