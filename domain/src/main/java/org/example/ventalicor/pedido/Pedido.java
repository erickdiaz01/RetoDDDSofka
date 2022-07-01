package org.example.ventalicor.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.pedido.values.*;
import org.example.ventalicor.producto.values.ProductoId;

import java.util.HashMap;
import java.util.Map;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Sede sede;
    protected Domiciliario domiciliario;
    protected DetalleDePedido detalleDePedido;
    protected ClienteId clienteId;
    protected MedioDePago medioDePago;
    protected Descuento descuento;

    public Pedido(PedidoId entityId) {
        super(entityId);
    }

    public static class DetalleDePedido extends Entity<DetalleDePedidoId> {
        private Map<ProductoId, CantidadProductos> lineasDetalle;
        private ValorTotal valorTotal;

        public DetalleDePedido(DetalleDePedidoId detalleDePedidoId, ValorTotal valorTotal) {
            super(detalleDePedidoId);
            this.lineasDetalle = new HashMap<>();
            this.valorTotal = valorTotal;
        }
        public void cambiarValorTotal(Integer valor){
            this.valorTotal=valorTotal.cambiarValor(valor);
        }
        public void agregarLineasDeProductos(ProductoId productoId,CantidadProductos cantidadProductos){
            this.lineasDetalle.put(productoId,cantidadProductos);
        }
    }
}
