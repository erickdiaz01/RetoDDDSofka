package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.pedido.Pedido;
import org.example.ventalicor.pedido.commands.AsignarDomiciliarioCommand;

public class AsignarDomiciliarioUseCase extends UseCase<RequestCommand<AsignarDomiciliarioCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarDomiciliarioCommand> asignarDomiciliarioCommandRequestCommand) {
        var command = asignarDomiciliarioCommandRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.asignarDomiciliario(command.getPedidoId(),command.getDomiciliario());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
