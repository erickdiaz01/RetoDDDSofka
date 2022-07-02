package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.pedido.values.CantidadProductos;
import org.example.ventalicor.pedido.values.PedidoId;
import org.example.ventalicor.producto.values.ProductoId;

public class AgregarLineaDeDetalleCommand extends Command {
    private final PedidoId pedidoId;
    private final ProductoId productoId;
    private final CantidadProductos cantidadProductos;

    public AgregarLineaDeDetalleCommand(PedidoId pedidoId, ProductoId productoId, CantidadProductos cantidadProductos) {
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
