package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.ReferenciaId;

public class CambiarNombreDeReferenciaDeProductoCommand extends Command {
    private final ReferenciaId referenciaId;
    private final String nombreReferencia;

    public CambiarNombreDeReferenciaDeProductoCommand(ReferenciaId referenciaId, String nombreReferencia) {
        this.referenciaId = referenciaId;
        this.nombreReferencia = nombreReferencia;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public String getNombreReferencia() {
        return nombreReferencia;
    }
}
