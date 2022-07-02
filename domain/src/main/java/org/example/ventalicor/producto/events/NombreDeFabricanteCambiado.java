package org.example.ventalicor.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.values.FabricanteId;

public class NombreDeFabricanteCambiado extends DomainEvent {
    private final FabricanteId fabricanteId;
    private final String nombreFabricante;

    public NombreDeFabricanteCambiado(FabricanteId fabricanteId, String nombreFabricante) {
        super("org.example.ventalicor.producto.events.NombreDeFabricanteCambiado");
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
