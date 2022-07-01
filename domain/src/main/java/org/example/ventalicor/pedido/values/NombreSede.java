package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreSede implements ValueObject<String> {
    private final String nombreSede;

    public NombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    @Override
    public String value() {
        return nombreSede;
    }
    public NombreSede cambiarNombre(String nombre){
        return new NombreSede(nombre);
    }
}
