package org.example.ventalicor.pedido;

import co.com.sofka.domain.generic.EventChange;
import org.example.ventalicor.pedido.events.*;
import org.example.ventalicor.pedido.values.Descuento;

public class PedidoEventChange extends EventChange {
    //TODO: Implementar REGLAS DE NEGOCIO CON EL ID PEDIDO Y LOS VALORES
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event)->{
            pedido.clienteId=event.getClienteId();
            if(event.getDetalleDePedido()==null){
                throw new IllegalArgumentException("El pedido debe contener un detalle");
            }
            pedido.detalleDePedido=event.getDetalleDePedido();
            pedido.sede=event.getSede();
            pedido.medioDePago=event.getMedioDePago();

        });
        apply((DomiciliarioAsignado event)->{
            pedido.domiciliario=event.getDomiciliario();
        });
        apply((MedioDePagoCambiado event)->{
            if (event.getMedioDePago()==null){
                throw new IllegalArgumentException("No puede cambiar el metodo de pago a uno nulo");
            }
            pedido.medioDePago = event.getMedioDePago();
        });
        apply((DescuentoAsignado event)->{
            if(event.getDescuento().value()<0||event.getDescuento().value()>1){
                throw new IllegalArgumentException("No puede haber un descuento negativo o mayor a 1");
            }
            pedido.descuento= event.getDescuento();
        });
apply((NombreDeSedeCambiado event)->{
    pedido.sede.cambiarNombreSede(event.getNombreSede());
});
apply((TelefonoDeDomiciliarioCambiado event)->{
    pedido.domiciliario.cambiarTelefonoDomiciliario(event.getTelefonoDomiciliario());
});
apply((LineaDeDetalleAgregada event)->{
    pedido.detalleDePedido.agregarLineaProductos(event.getProductoId(),event.getCantidadProductos());
});
apply((ValorTotalPedidoCambiado event)->{
    pedido.detalleDePedido.cambiarValorTotal(event.getValorTotal());
});

    }
}
