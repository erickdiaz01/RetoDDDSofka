package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.Identity;

public class CategoriaId extends Identity {
    public CategoriaId(String valor) {
        super(valor);
    }

    public CategoriaId() {
    }
    public static CategoriaId of(String valor){
        return new CategoriaId(valor);
    }
}
