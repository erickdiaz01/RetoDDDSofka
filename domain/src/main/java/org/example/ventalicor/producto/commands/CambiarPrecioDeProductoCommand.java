package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.ProductoId;

public class CambiarPrecioDeProductoCommand extends Command {
    private final ProductoId productoId;
    private final String moneda;
    private final Integer precio;

    public CambiarPrecioDeProductoCommand(ProductoId productoId, String moneda, Integer precio) {
        this.productoId = productoId;
        this.moneda = moneda;
        this.precio = precio;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public String getMoneda() {
        return moneda;
    }

    public Integer getPrecio() {
        return precio;
    }
}
