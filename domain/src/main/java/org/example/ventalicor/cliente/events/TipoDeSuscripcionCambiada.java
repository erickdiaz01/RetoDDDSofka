package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.values.SuscripcionId;
import org.example.ventalicor.cliente.values.TipoSuscripcion;

public class TipoDeSuscripcionCambiada extends DomainEvent {
    private final SuscripcionId suscripcionId;
    private final TipoSuscripcion nuevoTipo;

    public TipoDeSuscripcionCambiada(SuscripcionId suscripcionId, TipoSuscripcion nuevoTipo) {
        super("org.example.ventalicor.cliente.events.TipoDeSuscripcionCambiada");
        this.suscripcionId = suscripcionId;
        this.nuevoTipo = nuevoTipo;
    }

    public SuscripcionId getSuscripcionId() {
        return suscripcionId;
    }

    public TipoSuscripcion getNuevoTipo() {
        return nuevoTipo;
    }
}
