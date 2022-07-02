package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.ValueObject;

public class Embriagante implements ValueObject<Boolean> {
    private final boolean embriagante;

    public Embriagante(Boolean embriagante) {
        this.embriagante = embriagante;
    }

    @Override
    public Boolean value() {
        return embriagante;
    }
    public Embriagante cambiarEmbriagante(Boolean embriaga){
        return new Embriagante(embriaga);
    }
}
