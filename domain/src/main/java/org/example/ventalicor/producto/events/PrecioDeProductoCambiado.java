package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.values.ProductoId;

public class PrecioDeProductoCambiado extends DomainEvent {
    private final ProductoId productoId;
    private final String moneda;
    private final Integer precio;

    public PrecioDeProductoCambiado(ProductoId productoId, String moneda, Integer precio) {
        super("org.example.ventalicor.producto.events.PrecioDeProductoCambiado");
        this.productoId = productoId;
        this.moneda = moneda;
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public Integer getPrecio() {
        return precio;
    }
}
