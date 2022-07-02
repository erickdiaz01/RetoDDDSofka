package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.pedido.values.PedidoId;

public class ValorTotalPedidoCambiado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Integer valorTotal;

    public ValorTotalPedidoCambiado(PedidoId pedidoId, Integer valorTotal) {
        super("org.example.ventalicor.pedido.events.ValorTotalPedidoCambiado");
        this.pedidoId = pedidoId;
        this.valorTotal = valorTotal;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }
}
