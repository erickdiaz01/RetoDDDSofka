package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.ventalicor.producto.Producto;
import org.example.ventalicor.producto.commands.CrearProductoCommand;

public class CrearProductoUseCase extends UseCase<RequestCommand<CrearProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearProductoCommand> crearProductoCommandRequestCommand) {
      var command = crearProductoCommandRequestCommand.getCommand();
      var producto = new Producto(command.getProductoId(),command.getCategoria(),command.getFabricante(),command.getPrecio(),command.getReferencia());
      emit().onResponse(new ResponseEvents(producto.getUncommittedChanges()));
    }
}
