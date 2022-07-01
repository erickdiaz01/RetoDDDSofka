package org.example.ventalicor.producto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Precio.Props> {
private final String moneda;
private final Integer precio;

    public Precio(String moneda, Integer precio) {
        this.moneda =  Objects.requireNonNull(moneda);
        this.precio =  Objects.requireNonNull(precio);
    }

    @Override
    public Precio.Props value() {
        return new Props(){
@Override
            public String moneda(){
    return moneda;
}
@Override
            public Integer precio(){
    return precio;
}
        };
    }

    public interface Props {
        String moneda();

        Integer precio();
    }
}
