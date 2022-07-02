package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.Categoria;
import org.example.ventalicor.producto.Fabricante;
import org.example.ventalicor.producto.Referencia;
import org.example.ventalicor.producto.values.Precio;
import org.example.ventalicor.producto.values.ProductoId;

public class CreaProductoCommand extends Command {
    private final ProductoId productoId;
    private final Categoria categoria;
    private final Fabricante fabricante;
    private final Precio precio;
    private final Referencia referencia;

    public CreaProductoCommand(ProductoId productoId, Categoria categoria, Fabricante fabricante, Precio precio, Referencia referencia) {
        this.productoId = productoId;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.precio = precio;
        this.referencia = referencia;
    }

    public ProductoId getProductoId() {
        return productoId;
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
