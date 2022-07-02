package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.ProductoId;
import org.example.ventalicor.producto.values.ReferenciaId;

public class CambiarNombreDeReferenciaDeProductoCommand extends Command {
    private final ReferenciaId referenciaId;
    private final String nombreReferencia;
    private final ProductoId productoId;

    public CambiarNombreDeReferenciaDeProductoCommand(ReferenciaId referenciaId, String nombreReferencia, ProductoId productoId) {
        this.referenciaId = referenciaId;
        this.nombreReferencia = nombreReferencia;
        this.productoId = productoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public String getNombreReferencia() {
        return nombreReferencia;
    }
}
