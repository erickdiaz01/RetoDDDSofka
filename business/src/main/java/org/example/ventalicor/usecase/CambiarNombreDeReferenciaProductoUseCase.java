package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.producto.Producto;
import org.example.ventalicor.producto.commands.CambiarNombreDeReferenciaDeProductoCommand;

public class CambiarNombreDeReferenciaProductoUseCase extends UseCase<RequestCommand<CambiarNombreDeReferenciaDeProductoCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarNombreDeReferenciaDeProductoCommand> cambiarNombreDeReferenciaDeProductoCommandRequestCommand) {
        var command = cambiarNombreDeReferenciaDeProductoCommandRequestCommand.getCommand();
        var producto = Producto.from(command.getProductoId(),repository().getEventsBy(command.getProductoId().value()));
        producto.cambiarNombreDeReferencia(command.getProductoId(),command.getReferenciaId(), command.getNombreReferencia());

        emit().onResponse(new ResponseEvents(producto.getUncommittedChanges()));
    }
}
