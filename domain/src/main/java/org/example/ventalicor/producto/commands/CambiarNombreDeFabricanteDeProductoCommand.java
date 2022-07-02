package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.FabricanteId;

public class CambiarNombreDeFabricanteDeProductoCommand extends Command {
    private final FabricanteId fabricanteId;
    private final String nombreFabricante;

    public CambiarNombreDeFabricanteDeProductoCommand(FabricanteId fabricanteId, String nombreFabricante) {
        this.fabricanteId = fabricanteId;
        this.nombreFabricante = nombreFabricante;
    }

    public FabricanteId getFabricanteId() {
        return fabricanteId;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }
}
