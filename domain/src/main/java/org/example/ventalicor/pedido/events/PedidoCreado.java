package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.pedido.DetallePedido;
import org.example.ventalicor.pedido.Sede;
import org.example.ventalicor.pedido.values.Descuento;
import org.example.ventalicor.pedido.values.PedidoId;

public class PedidoCreado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Sede sede;
    private final DetallePedido detalleDePedido;
    private final ClienteId clienteId;
    private final MedioDePago medioDePago;
    private final Descuento descuento;

    public PedidoCreado(PedidoId pedidoId, Sede sede, DetallePedido detalleDePedido, ClienteId clienteId, MedioDePago medioDePago, Descuento descuento) {
        super("org.example.ventalicor.pedido.events.PedidoCreado");
        this.pedidoId = pedidoId;
        this.sede = sede;
        this.detalleDePedido = detalleDePedido;
        this.clienteId = clienteId;
        this.medioDePago = medioDePago;
        this.descuento = descuento;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Sede getSede() {
        return sede;
    }

    public DetallePedido getDetalleDePedido() {
        return detalleDePedido;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
