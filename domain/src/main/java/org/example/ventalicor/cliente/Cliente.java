package org.example.ventalicor.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.ventalicor.cliente.values.ClienteId;

import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {
    protected CuentaAplicacion cuentaAplicacion;
    protected Set<MedioDePago> mediosDePago;
    protected Suscripcion suscripcion;

    public Cliente(ClienteId clienteId) {
        super(clienteId);
    }
}
