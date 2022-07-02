package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

import java.util.Set;

public class MedioDePagoAgregado extends DomainEvent {
    private final CuentaAplicacionId cuentaAplicacionId;
    private final MedioDePago medioDePago;
    private final Set<MedioDePago> mediosDePago;

    public MedioDePagoAgregado(CuentaAplicacionId cuentaAplicacionId, MedioDePago medioDePago, Set<MedioDePago> mediosDePago) {
        super("org.example.ventalicor.cliente.events.MedioDePagoAgregado");
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.medioDePago = medioDePago;
        this.mediosDePago = mediosDePago;
    }

    public Set<MedioDePago> getMediosDePago() {
        return mediosDePago;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}
