package org.example.ventalicor.producto.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.values.FabricanteId;

public class CambiarPaisDeFabricanteDeProductoCommand extends Command {
    private final FabricanteId fabricanteId;
    private final String paisFabricante;

    public CambiarPaisDeFabricanteDeProductoCommand(FabricanteId fabricanteId, String paisFabricante) {
        this.fabricanteId = fabricanteId;
        this.paisFabricante = paisFabricante;
    }

    public FabricanteId getFabricanteId() {
        return fabricanteId;
    }

    public String getPaisFabricante() {
        return paisFabricante;
    }
}
