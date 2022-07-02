package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.cliente.Cliente;
import org.example.ventalicor.cliente.commands.CrearClienteCommand;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClienteCommand> crearClienteCommandRequestCommand) {

        var command = crearClienteCommandRequestCommand.getCommand();
        var cliente = new Cliente(command.getClienteId(),new CuentaAplicacionId(),command.getTelefonoCliente(),command.getNombreCompletoCliente(),command.getDirecionCliente(),command.getTipoSuscripcion());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
