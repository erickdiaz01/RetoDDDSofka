package org.example.ventalicor.cliente.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.cliente.values.*;

public class CrearClienteCommand extends Command {
    private final DirecionCliente direcionCliente;
    private final TelefonoCliente telefonoCliente;
    private final NombreCompletoCliente nombreCompletoCliente;
    private final TipoSuscripcion tipoSuscripcion;
    private final ClienteId clienteId;

    public CrearClienteCommand(DirecionCliente direcionCliente, TelefonoCliente telefonoCliente, NombreCompletoCliente nombreCompletoCliente, TipoSuscripcion tipoSuscripcion, ClienteId clienteId) {

        this.direcionCliente = direcionCliente;
        this.telefonoCliente = telefonoCliente;
        this.nombreCompletoCliente = nombreCompletoCliente;
        this.tipoSuscripcion = tipoSuscripcion;
        this.clienteId = clienteId;
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

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
