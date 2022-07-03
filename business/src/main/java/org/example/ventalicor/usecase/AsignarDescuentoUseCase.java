package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.pedido.Pedido;
import org.example.ventalicor.pedido.commands.AsignarDescuentoCommand;

public class AsignarDescuentoUseCase extends UseCase<RequestCommand<AsignarDescuentoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarDescuentoCommand> asignarDescuentoCommandRequestCommand) {
        var command = asignarDescuentoCommandRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));
        pedido.asignarDescuento(command.getPedidoId(),command.getDescuento());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
