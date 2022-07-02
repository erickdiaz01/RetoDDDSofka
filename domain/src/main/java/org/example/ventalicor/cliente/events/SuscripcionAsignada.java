package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.Suscripcion;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class SuscripcionAsignada extends DomainEvent {

    private final CuentaAplicacionId cuentaAplicacionId;
    private final Suscripcion suscripcion;

    public SuscripcionAsignada(CuentaAplicacionId cuentaAplicacionId, Suscripcion suscripcion) {
        super("org.example.ventalicor.cliente.events.SuscripcionAsignada");
        this.cuentaAplicacionId = cuentaAplicacionId;

        this.suscripcion = suscripcion;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
}
