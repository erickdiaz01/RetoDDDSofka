package org.example.ventalicor.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class DatosMedioDePagoDeCliente implements ValueObject<String> {
private final String datosMedioDePago;

    public DatosMedioDePagoDeCliente(String datosMedioDePago) {
        this.datosMedioDePago = datosMedioDePago;
    }

    @Override
    public String value() {
        return datosMedioDePago;
    }
    public DatosMedioDePagoDeCliente cambiarDatosMedioDePago(String datosMedioDePago){
        return new DatosMedioDePagoDeCliente(datosMedioDePago);
    }
}
