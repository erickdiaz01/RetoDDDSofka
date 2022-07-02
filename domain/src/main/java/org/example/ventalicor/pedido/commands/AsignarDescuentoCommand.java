package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.pedido.values.PedidoId;

public class AsignarDescuentoCommand extends Command {
    private final PedidoId pedidoId;
    private final Double descuento;

    public AsignarDescuentoCommand(PedidoId pedidoId, Double descuento) {
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
