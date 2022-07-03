package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.pedido.Pedido;
import org.example.ventalicor.pedido.commands.CambiarMedioDePagoCommand;

public class CambiarMetodoDePagoUseCase extends UseCase<RequestCommand<CambiarMedioDePagoCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarMedioDePagoCommand> cambiarMedioDePagoCommandRequestCommand) {
        var command = cambiarMedioDePagoCommandRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.cambiarMedioDePago(command.getPedidoId(),command.getMedioDePago());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
