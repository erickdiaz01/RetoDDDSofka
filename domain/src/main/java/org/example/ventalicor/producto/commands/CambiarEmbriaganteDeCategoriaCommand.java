package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.CategoriaId;

public class CambiarEmbriaganteDeCategoriaCommand extends Command {
    private final CategoriaId categoriaId;
    private final Boolean embriaga;

    public CambiarEmbriaganteDeCategoriaCommand(CategoriaId categoriaId, Boolean embriaga) {
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
