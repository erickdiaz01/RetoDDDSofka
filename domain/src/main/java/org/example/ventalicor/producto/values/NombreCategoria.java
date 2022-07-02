package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.ValueObject;

public class NombreCategoria implements ValueObject<String> {
    private final String nombreCategoria;

    public NombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String value() {
        return nombreCategoria;
    }
    public NombreCategoria cambiarNombre(String nombre){
        return new NombreCategoria(nombre);
    }
}
