package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.CategoriaId;

public class CambiarNombreDeCategoriaDeProductoCommand extends Command {
    private final CategoriaId categoriaId;
    private final String nombreCategoria;

    public CambiarNombreDeCategoriaDeProductoCommand(CategoriaId categoriaId, String nombreCategoria) {
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
