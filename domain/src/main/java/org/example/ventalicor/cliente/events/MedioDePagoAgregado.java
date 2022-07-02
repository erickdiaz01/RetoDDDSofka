package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class MedioDePagoAgregado extends DomainEvent {
    private final CuentaAplicacionId cuentaAplicacionId;
    private final MedioDePago medioDePago;

    public MedioDePagoAgregado(CuentaAplicacionId cuentaAplicacionId, MedioDePago medioDePago) {
        super("org.example.ventalicor.cliente.events.MedioDePagoAgregado");
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.medioDePago = medioDePago;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}
