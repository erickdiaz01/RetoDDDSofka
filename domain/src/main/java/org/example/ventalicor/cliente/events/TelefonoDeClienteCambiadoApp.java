package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class TelefonoDeClienteCambiadoApp extends DomainEvent {
    private final CuentaAplicacionId cuentaAplicacionId;
    private final String nuevoTelefono;

    public TelefonoDeClienteCambiadoApp(CuentaAplicacionId cuentaAplicacionId, String nuevoTelefono) {
        super("org.example.ventalicor.cliente.events.TelefonoDeClienteCambiadoApp");
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.nuevoTelefono = nuevoTelefono;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public String getNuevoTelefono() {
        return nuevoTelefono;
    }
}
