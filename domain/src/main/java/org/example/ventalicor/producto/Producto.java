package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.ventalicor.producto.values.Precio;
import org.example.ventalicor.producto.values.ProductoId;

public class Producto extends AggregateEvent<ProductoId> {
    protected Categoria categoria;
    protected Fabricante fabricante;
    protected Precio precio;
    protected Referencia referencia;
    public Producto(ProductoId productoId) {
        super(productoId);
    }
}
