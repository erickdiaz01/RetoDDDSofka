package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.DatosMedioDePagoDeCliente;
import org.example.ventalicor.cliente.values.MedioDePagoId;
import org.example.ventalicor.cliente.values.TipoMedioDePago;
import org.example.ventalicor.pedido.DetallePedido;
import org.example.ventalicor.pedido.Sede;
import org.example.ventalicor.pedido.commands.CrearPedidoCommand;
import org.example.ventalicor.pedido.events.PedidoCreado;
import org.example.ventalicor.pedido.values.*;
import org.example.ventalicor.producto.values.Precio;
import org.example.ventalicor.producto.values.ProductoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearPedidoUseCaseTest {
    @InjectMocks
    CrearPedidoUseCase useCase;
    @Test
    public void crearPedido(){
        //Arrange
        PedidoId pedidoId = PedidoId.of("PedidoN");
        Map<ProductoId, CantidadProductos> listaDetalle = new HashMap<>();
        listaDetalle.put(ProductoId.of("Prod1"),new CantidadProductos(5));
        listaDetalle.put(ProductoId.of("Prod2"),new CantidadProductos(2));

Sede sede = new Sede(SedeId.of("Sede1"),new DireccionSede("Calle6Carrera80"),new NombreSede("Banderas"));
        ValorTotal valorTotal = new ValorTotal(50000);
        DetallePedido detallePedido = new DetallePedido(new DetalleDePedidoId(),listaDetalle,valorTotal);
        MedioDePago medioDePago = new MedioDePago(MedioDePagoId.of("Tarj1"),new DatosMedioDePagoDeCliente("1489"),new TipoMedioDePago(TipoMedioDePago.tipoMedioDePago.TARJETADEBITO));
Descuento descuento = new Descuento(0.15);
        var command = new CrearPedidoCommand(pedidoId,sede,detallePedido,ClienteId.of("Clien1"),medioDePago,descuento);

        //ACT
        var events = UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //Asserts
        var event= (PedidoCreado)events.get(0);
        Assertions.assertEquals("Calle6Carrera80",event.getSede().getDireccionSede().value());
        Assertions.assertEquals(50000,event.getDetalleDePedido().getValorTotal().value());
        Assertions.assertEquals(2,event.getDetalleDePedido().getLineasDeProductos().size());

    }
}