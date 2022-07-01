package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descuento implements ValueObject<Double> {
 private final double descuento;

    public Descuento(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public Double value() {
        return descuento;
    }
}
