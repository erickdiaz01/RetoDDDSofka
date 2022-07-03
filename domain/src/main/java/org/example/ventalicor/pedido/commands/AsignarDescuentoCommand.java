package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.pedido.values.Descuento;
import org.example.ventalicor.pedido.values.PedidoId;

public class AsignarDescuentoCommand extends Command {
    private final PedidoId pedidoId;
    private final Descuento descuento;

    public AsignarDescuentoCommand(PedidoId pedidoId, Descuento descuento) {
        this.pedidoId = pedidoId;
        this.descuento = descuento;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
