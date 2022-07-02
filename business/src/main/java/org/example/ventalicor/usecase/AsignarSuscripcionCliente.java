package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.cliente.Cliente;
import org.example.ventalicor.cliente.commands.AsignarSuscripcionCommand;

public class AsignarSuscripcionCliente extends UseCase<RequestCommand<AsignarSuscripcionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarSuscripcionCommand> asignarSuscripcionCommandRequestCommand) {
        var command = asignarSuscripcionCommandRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),repository().getEventsBy(command.getClienteId().value()));

    }
}
