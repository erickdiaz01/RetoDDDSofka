package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.ventalicor.pedido.events.PedidoCreado;
import org.example.ventalicor.usecase.service.EmailCuentaCreadaService;
import org.example.ventalicor.usecase.service.EmailPedidoCreadoService;

import java.util.List;

public class EmailCreacionDePedidoClienteUseCase extends UseCase<TriggeredEvent<PedidoCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PedidoCreado> pedidoCreadoTriggeredEvent) {
        var event = pedidoCreadoTriggeredEvent.getDomainEvent();
        var service=getService(EmailPedidoCreadoService.class).orElseThrow();

        String body = String.format("Su pedido ha sido creado con exito, con id %s y valor total de %s",event.getPedidoId().value(),event.getDetalleDePedido().getValorTotal().value());
        service.enviarEmail(event.getPedidoId(),body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
