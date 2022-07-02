package org.example.ventalicor.cliente.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.cliente.Suscripcion;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class AsignarSuscripcionCommand extends Command {
    private final CuentaAplicacionId cuentaAplicacionId;
    private final ClienteId clienteId;
    private final Suscripcion suscripcion;

    public AsignarSuscripcionCommand(CuentaAplicacionId cuentaAplicacionId, ClienteId clienteId, Suscripcion suscripcion) {
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.clienteId = clienteId;
        this.suscripcion = suscripcion;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
}
