package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class CantidadProductos implements ValueObject <Integer> {
    private final Integer cantidadProductos;

    public CantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    @Override
    public Integer value() {
        return null;
    }
}
