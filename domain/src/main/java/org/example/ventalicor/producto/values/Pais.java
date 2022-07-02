package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.ValueObject;

public class Pais implements ValueObject<String> {
    private final String pais;

    public Pais(String pais) {
        this.pais = pais;
    }

    @Override
    public String value() {
        return pais;
    }
    public Pais cambiarPais(String nuevoPais){
        return new Pais(nuevoPais);
    }
}
