package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.Identity;

public class FabricanteId extends Identity {
    public FabricanteId(String valor) {
        super(valor);
    }

    public FabricanteId() {
    }
    public static FabricanteId of(String valor){
        return new FabricanteId(valor);
    }
}
