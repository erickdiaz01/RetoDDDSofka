package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.pedido.values.DomiciliarioId;
import org.example.ventalicor.pedido.values.PedidoId;

public class CambiarTelefonoDomiciliarioCommand extends Command {
    private final PedidoId pedidoId;
    private final DomiciliarioId domiciliarioId;
    private final String telefonoDomiciliario;

    public CambiarTelefonoDomiciliarioCommand(PedidoId pedidoId, DomiciliarioId domiciliarioId, String telefonoDomiciliario) {
        this.pedidoId = pedidoId;
        this.domiciliarioId = domiciliarioId;
        this.telefonoDomiciliario = telefonoDomiciliario;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public DomiciliarioId getDomiciliarioId() {
        return domiciliarioId;
    }

    public String getTelefonoDomiciliario() {
        return telefonoDomiciliario;
    }
}
