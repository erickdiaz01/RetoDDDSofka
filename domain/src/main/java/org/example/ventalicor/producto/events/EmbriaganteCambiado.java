package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.values.CategoriaId;

public class EmbriaganteCambiado extends DomainEvent {
    private final CategoriaId categoriaId;
    private final Boolean embriaga;

    public EmbriaganteCambiado(CategoriaId categoriaId, Boolean embriaga) {
        super("org.example.ventalicor.producto.events.EmbriaganteCambiado");
        this.categoriaId = categoriaId;
        this.embriaga = embriaga;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public Boolean getEmbriaga() {
        return embriaga;
    }
}
