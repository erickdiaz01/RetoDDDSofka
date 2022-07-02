package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.pedido.values.PedidoId;

public class DescuentoAsignado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Double descuento;

    public DescuentoAsignado(PedidoId pedidoId, Double descuento) {
        super("org.example.ventalicor.pedido.events.DescuentoAsignado");
        this.pedidoId = pedidoId;
        this.descuento = descuento;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Double getDescuento() {
        return descuento;
    }
}
