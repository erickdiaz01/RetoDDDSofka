package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.values.CategoriaId;

public class NombreDeCategoriaDeProductoCambiado extends DomainEvent {
    private final CategoriaId categoriaId;
    private final String nombreCategoria;

    public NombreDeCategoriaDeProductoCambiado(CategoriaId categoriaId, String nombreCategoria) {
        super("org.example.ventalicor.product.NombreDeCategoriaDeProductoCambiado");
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
}
