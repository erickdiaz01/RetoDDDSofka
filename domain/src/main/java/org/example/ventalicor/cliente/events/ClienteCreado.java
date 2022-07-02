package org.example.ventalicor.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.values.*;

public class ClienteCreado extends DomainEvent {
    private final ClienteId clienteId;
    private final CuentaAplicacionId cuentaAplicacionId;
    private final DirecionCliente direcionCliente;
    private final TelefonoCliente telefonoCliente;
    private final NombreCompletoCliente nombreCompletoCliente;
    private final TipoSuscripcion tipoSuscripcion;

    public ClienteCreado(ClienteId clienteId, CuentaAplicacionId cuentaAplicacionId, DirecionCliente direcionCliente, TelefonoCliente telefonoCliente, NombreCompletoCliente nombreCompletoCliente, TipoSuscripcion tipoSuscripcion) {
        super("org.example.ventalicor.cliente.events.ClienteCreado");
        this.clienteId = clienteId;
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.direcionCliente = direcionCliente;
        this.telefonoCliente = telefonoCliente;
        this.nombreCompletoCliente = nombreCompletoCliente;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public DirecionCliente getDirecionCliente() {
        return direcionCliente;
    }

    public TelefonoCliente getTelefonoCliente() {
        return telefonoCliente;
    }

    public NombreCompletoCliente getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }
}
