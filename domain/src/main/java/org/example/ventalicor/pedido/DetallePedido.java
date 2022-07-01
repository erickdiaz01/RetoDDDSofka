package org.example.ventalicor.pedido;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.pedido.values.CantidadProductos;
import org.example.ventalicor.pedido.values.DetalleDePedidoId;
import org.example.ventalicor.pedido.values.ValorTotal;
import org.example.ventalicor.producto.values.ProductoId;

import java.util.Map;

public class DetallePedido extends Entity<DetalleDePedidoId> {
    private Map<ProductoId, CantidadProductos> lineasDeProductos;
    private ValorTotal valorTotal;

    public DetallePedido(DetalleDePedidoId entityId, Map<ProductoId, CantidadProductos> lineasDeProductos, ValorTotal valorTotal) {
        super(entityId);
        this.lineasDeProductos = lineasDeProductos;
        this.valorTotal = valorTotal;
    }
    public void agregarLineaProductos(ProductoId productoId,CantidadProductos cantidadProductos){
        this.lineasDeProductos.put(productoId,cantidadProductos);
    }
    public void cambiarValorTotal(Integer valor){
        this.valorTotal=valorTotal.cambiarValor(valor);
    }
}
