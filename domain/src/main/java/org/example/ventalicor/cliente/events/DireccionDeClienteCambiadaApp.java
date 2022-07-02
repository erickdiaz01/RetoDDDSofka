package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class DireccionDeClienteCambiadaApp extends DomainEvent {
    private final CuentaAplicacionId cuentaAplicacionId;
    private final String nuevaDireccionCliente;

    public DireccionDeClienteCambiadaApp(CuentaAplicacionId cuentaAplicacionId, String nuevaDireccionCliente) {
        super("org.example.ventalicor.cliente");
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.nuevaDireccionCliente = nuevaDireccionCliente;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public String getNuevaDireccionCliente() {
        return nuevaDireccionCliente;
    }
}
