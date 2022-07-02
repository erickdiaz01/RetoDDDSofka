package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.values.ProductoId;
import org.example.ventalicor.producto.values.ReferenciaId;

public class NombreDeReferenciaCambiado extends DomainEvent {
    private final ProductoId productoId;
    private final ReferenciaId referenciaId;
    private final String nombreReferencia;

    public NombreDeReferenciaCambiado(ProductoId productoId, ReferenciaId referenciaId, String nombreReferencia) {
        super("org.example.ventalicor.producto.events.NombreDeReferenciaCambiado");
        this.productoId = productoId;
        this.referenciaId = referenciaId;
        this.nombreReferencia = nombreReferencia;
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
