package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.pedido.values.PedidoId;

public class MedioDePagoCambiado extends DomainEvent {
    private final PedidoId pedidoId;
    private final MedioDePago medioDePago;

    public MedioDePagoCambiado(PedidoId pedidoId, MedioDePago medioDePago) {
        super("org.example.ventalicor.pedido.events.MedioDePagoCambiado");
        this.pedidoId = pedidoId;
        this.medioDePago = medioDePago;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}
