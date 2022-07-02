package org.example.ventalicor.cliente.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class AgregarMedioDePagoCommand extends Command {
    private final ClienteId clienteId;
    private final CuentaAplicacionId cuentaAplicacionId;
    private final MedioDePago medioDePago;

    public AgregarMedioDePagoCommand(ClienteId clienteId, CuentaAplicacionId cuentaAplicacionId, MedioDePago medioDePago) {
        this.clienteId = clienteId;
        this.cuentaAplicacionId = cuentaAplicacionId;
        this.medioDePago = medioDePago;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CuentaAplicacionId getCuentaAplicacionId() {
        return cuentaAplicacionId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}
