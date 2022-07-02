package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.producto.values.CategoriaId;
import org.example.ventalicor.producto.values.Embriagante;
import org.example.ventalicor.producto.values.NombreCategoria;

public class Categoria extends Entity<CategoriaId> {
    private NombreCategoria nombreCategoria;
    private Embriagante embriagante;

    public Categoria(CategoriaId entityId, NombreCategoria nombreCategoria, Embriagante embriagante) {
        super(entityId);
        this.nombreCategoria = nombreCategoria;
        this.embriagante = embriagante;
    }

    public void cambiarNombreCategoria(String nuevoNombre){
        this.nombreCategoria=nombreCategoria.cambiarNombre(nuevoNombre);
    }
    public void cambiarEmbriagante(Boolean embriaga){
        this.embriagante=embriagante.cambiarEmbriagante(embriaga);
    }
}
