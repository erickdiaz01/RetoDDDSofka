package org.example.ventalicor.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.pedido.values.CantidadProductos;
import org.example.ventalicor.pedido.values.PedidoId;
import org.example.ventalicor.producto.values.ProductoId;

public class LineaDeDetalleAgregada extends DomainEvent {
    private final PedidoId pedidoId;
    private final ProductoId productoId;
    private final CantidadProductos cantidadProductos;

    public LineaDeDetalleAgregada(PedidoId pedidoId, ProductoId productoId, CantidadProductos cantidadProductos) {
        super("org.example.ventalicor.pedido.events.LineaDeDetalleAgregada");
        this.pedidoId = pedidoId;
        this.productoId = productoId;
        this.cantidadProductos = cantidadProductos;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public CantidadProductos getCantidadProductos() {
        return cantidadProductos;
    }
}
