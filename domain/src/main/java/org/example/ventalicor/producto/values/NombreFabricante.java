package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreFabricante implements ValueObject<String> {
    private final String nombreFabricante;

    public NombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    @Override
    public String value() {
        return nombreFabricante;
    }
    public NombreFabricante cambiarNombre(String nuevoNombre){
        return new NombreFabricante(nuevoNombre);
    }
}
