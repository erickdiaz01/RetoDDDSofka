package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.pedido.Domiciliario;
import org.example.ventalicor.pedido.values.PedidoId;

public class AsignarDomiciliarioCommand extends Command {
    private final PedidoId pedidoId;
    private final Domiciliario domiciliario;

    public AsignarDomiciliarioCommand(PedidoId pedidoId, Domiciliario domiciliario) {
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
