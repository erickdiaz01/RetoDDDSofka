package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.pedido.values.PedidoId;

public class CambiarValorTotalDePedidoCommand extends Command {
    private final PedidoId pedidoId;
    private final Integer valorTotal;

    public CambiarValorTotalDePedidoCommand(PedidoId pedidoId, Integer valorTotal) {
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
