package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.producto.values.CategoriaId;

public class Categoria extends Entity<CategoriaId> {
    public Categoria(CategoriaId categoriaId) {
        super(categoriaId);
    }
}
