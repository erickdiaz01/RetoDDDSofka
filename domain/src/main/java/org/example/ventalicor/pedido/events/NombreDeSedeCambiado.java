package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.pedido.values.NombreSede;

public class NombreDeSedeCambiado extends DomainEvent {
    private final String nombreSede;

    public NombreDeSedeCambiado(String nombreSede) {
        super("org.example.ventalicor.pedido.events.NombreDeSedeCambiado");
        this.nombreSede = nombreSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }
}
