package org.example.ventalicor.cliente.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class CambiarDireccionDeClienteAppCommand extends Command {

    private final CuentaAplicacionId cuentaAplicacionId;
    private final String nuevaDireccionCliente;
    private final ClienteId clienteId;

    public CambiarDireccionDeClienteAppCommand(CuentaAplicacionId cuentaAplicacionId, String nuevaDireccionCliente, ClienteId clienteId) {
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.nuevaDireccionCliente = nuevaDireccionCliente;
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public String getNuevaDireccionCliente() {
        return nuevaDireccionCliente;
    }
}
