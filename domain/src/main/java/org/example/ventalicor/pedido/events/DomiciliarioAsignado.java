package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.pedido.Domiciliario;
import org.example.ventalicor.pedido.values.PedidoId;

public class DomiciliarioAsignado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Domiciliario domiciliario;

    public DomiciliarioAsignado(PedidoId pedidoId, Domiciliario domiciliario) {
        super("org.example.ventalicor.pedido.events.DomiciliarioAsignado");
        this.pedidoId = pedidoId;
        this.domiciliario = domiciliario;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Domiciliario getDomiciliario() {
        return domiciliario;
    }
}
