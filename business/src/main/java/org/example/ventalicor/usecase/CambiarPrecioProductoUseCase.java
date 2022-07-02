package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.pedido.Pedido;
import org.example.ventalicor.producto.Producto;
import org.example.ventalicor.producto.commands.CambiarPrecioDeProductoCommand;

public class CambiarPrecioProductoUseCase extends UseCase<RequestCommand<CambiarPrecioDeProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarPrecioDeProductoCommand> cambiarPrecioDeProductoCommandRequestCommand) {
        var command = cambiarPrecioDeProductoCommandRequestCommand.getCommand();
        var producto = Producto.from(command.getProductoId(),repository().getEventsBy(command.getProductoId().value()));
        producto.cambiarPrecioProducto(command.getProductoId(),command.getMoneda(), command.getPrecio());

        emit().onResponse(new ResponseEvents(producto.getUncommittedChanges()));
    }
}
