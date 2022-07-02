package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.pedido.values.DomiciliarioId;
import org.example.ventalicor.pedido.values.PedidoId;

public class TelefonoDeDomiciliarioCambiado extends DomainEvent {
    private final PedidoId pedidoId;
    private final DomiciliarioId domiciliarioId;
    private final String telefonoDomiciliario;

    public TelefonoDeDomiciliarioCambiado(PedidoId pedidoId, DomiciliarioId domiciliarioId, String telefonoDomiciliario) {
        super("org.example.ventalicor.pedido.events.TelefonoDeDomiciliarioCambiado");
        this.pedidoId = pedidoId;
        this.domiciliarioId = domiciliarioId;
        this.telefonoDomiciliario = telefonoDomiciliario;
    }

    public DomiciliarioId getDomiciliarioId() {
        return domiciliarioId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public String getTelefonoDomiciliario() {
        return telefonoDomiciliario;
    }
}
