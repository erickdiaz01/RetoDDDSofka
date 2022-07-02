package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.pedido.values.PedidoId;

public class CambiarMedioDePagoCommand extends Command {
    private final PedidoId pedidoId;
    private final MedioDePago medioDePago;

    public CambiarMedioDePagoCommand(PedidoId pedidoId, MedioDePago medioDePago) {
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
