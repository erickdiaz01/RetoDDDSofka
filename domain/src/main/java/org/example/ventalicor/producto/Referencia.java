package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.producto.values.NombreReferencia;
import org.example.ventalicor.producto.values.ReferenciaId;


public class Referencia extends Entity<ReferenciaId> {
    private NombreReferencia nombreReferencia;

    public Referencia(ReferenciaId referenciaId, NombreReferencia nombreReferencia) {
        super(referenciaId);
        this.nombreReferencia = nombreReferencia;
    }

    public void cambiarNombreReferencia(String nuevoNombre){
        this.nombreReferencia=nombreReferencia.cambiarNombre(nuevoNombre);
    }

    public NombreReferencia getNombreReferencia() {
        return nombreReferencia;
    }
}
