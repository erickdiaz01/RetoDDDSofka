package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.pedido.Pedido;
import org.example.ventalicor.pedido.commands.CrearPedidoCommand;
import org.example.ventalicor.producto.Producto;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedidoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedidoCommand> crearPedidoCommandRequestCommand) {
        var command = crearPedidoCommandRequestCommand.getCommand();
        var pedido = new Pedido(command.getPedidoId(),command.getSede(),command.getDetalleDePedido(),command.getClienteId(),command.getMedioDePago(),command.getDescuento());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
