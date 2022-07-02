package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.values.FabricanteId;

public class PaisDeFabricanteCambiado extends DomainEvent {
    private final FabricanteId fabricanteId;
    private final String paisFabricante;

    public PaisDeFabricanteCambiado(FabricanteId fabricanteId, String paisFabricante) {
        super("org.example.ventalicor.producto.events.PaisDeFabricanteCambiado");
        this.fabricanteId = fabricanteId;
        this.paisFabricante = paisFabricante;
    }

    public String getPaisFabricante() {
        return paisFabricante;
    }
}
