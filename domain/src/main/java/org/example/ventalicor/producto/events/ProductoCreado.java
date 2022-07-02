package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.Categoria;
import org.example.ventalicor.producto.Fabricante;
import org.example.ventalicor.producto.Referencia;
import org.example.ventalicor.producto.values.Precio;
import org.example.ventalicor.producto.values.ProductoId;

public class ProductoCreado extends DomainEvent {


    private final Categoria categoria;
    private final Fabricante fabricante;
    private final Precio precio;
    private final Referencia referencia;

    public ProductoCreado(Categoria categoria, Fabricante fabricante, Precio precio, Referencia referencia) {
        super("org.example.ventalicor.producto");
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.precio = precio;
        this.referencia = referencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Referencia getReferencia() {
        return referencia;
    }
}
