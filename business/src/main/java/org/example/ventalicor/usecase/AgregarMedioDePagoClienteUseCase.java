package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.cliente.Cliente;
import org.example.ventalicor.cliente.commands.AgregarMedioDePagoCommand;

public class AgregarMedioDePagoClienteUseCase extends UseCase<RequestCommand<AgregarMedioDePagoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMedioDePagoCommand> agregarMedioDePagoCommandRequestCommand) {
        var command = agregarMedioDePagoCommandRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),repository().getEventsBy(command.getClienteId().value()));
        cliente.agregarMedioDePago(command.getCuentaAplicacionId(),command.getMedioDePago());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
