package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreReferencia implements ValueObject<String> {
    private final String nombreReferencia;

    public NombreReferencia(String nombreReferencia) {
        this.nombreReferencia = nombreReferencia;
    }

    @Override
    public String value() {
        return nombreReferencia;
    }

    public NombreReferencia cambiarNombre(String nuevoNombre){
        return new NombreReferencia(nuevoNombre);
    }
}
