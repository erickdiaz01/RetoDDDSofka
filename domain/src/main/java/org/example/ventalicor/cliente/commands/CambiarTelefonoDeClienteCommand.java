package org.example.ventalicor.cliente.commands;

import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class CambiarTelefonoDeClienteCommand {
    private final CuentaAplicacionId cuentaAplicacionId;
    private final ClienteId clienteId;
    private final String nuevoTelefono;

    public CambiarTelefonoDeClienteCommand(CuentaAplicacionId cuentaAplicacionId, ClienteId clienteId, String nuevoTelefono) {
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.clienteId = clienteId;
        this.nuevoTelefono = nuevoTelefono;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public String getNuevoTelefono() {
        return nuevoTelefono;
    }
}
