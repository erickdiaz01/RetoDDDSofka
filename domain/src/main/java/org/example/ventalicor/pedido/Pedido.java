package org.example.ventalicor.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.pedido.events.*;
import org.example.ventalicor.pedido.values.*;
import org.example.ventalicor.producto.values.ProductoId;

import java.util.List;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Sede sede;
    protected Domiciliario domiciliario;
    protected DetallePedido detalleDePedido;
    protected ClienteId clienteId;
    protected MedioDePago medioDePago;
    protected Descuento descuento;

    public Pedido(PedidoId pedidoId, Sede sede, DetallePedido detalleDePedido, ClienteId clienteId, MedioDePago medioDePago, Descuento descuento) {
        super(pedidoId);
        appendChange(new PedidoCreado(pedidoId,sede,detalleDePedido,clienteId,medioDePago,descuento)).apply();
        subscribe(new PedidoEventChange(this));

    }
    public Pedido(PedidoId pedidoId){
        super(pedidoId);
        subscribe(new PedidoEventChange(this));
    }
    public static Pedido from (PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }
    public void asignarDomiciliario(PedidoId pedidoId,Domiciliario domiciliario){
        appendChange(new DomiciliarioAsignado(pedidoId,domiciliario)).apply();

    }
    public void cambiarMedioDePago(PedidoId pedidoId,MedioDePago medioDePago){
        appendChange(new MedioDePagoCambiado(pedidoId,medioDePago)).apply();
    }
    public void asignarDescuento(PedidoId pedidoId,Descuento descuento){
        appendChange(new DescuentoAsignado(pedidoId,descuento)).apply();

    }
    public void cambiarNombreDeSede(String nombreSede){
        appendChange(new NombreDeSedeCambiado(nombreSede)).apply();
    }
    public void cambiarNumeroDeDomiciliario(PedidoId pedidoId,DomiciliarioId domiciliarioId,String telefonoDomiciliario){
        appendChange(new TelefonoDeDomiciliarioCambiado(pedidoId,domiciliarioId,telefonoDomiciliario)).apply();
    }
    public void agregarLineaDeDetalle(PedidoId pedidoId,ProductoId productoId, CantidadProductos cantidadProductos){
        appendChange(new LineaDeDetalleAgregada(pedidoId,productoId,cantidadProductos)).apply();
    }
    public void cambiarValorTotalDeDetalle(PedidoId pedidoId,Integer valorTotal){
        appendChange(new ValorTotalPedidoCambiado(pedidoId,valorTotal)).apply();
    }
}
