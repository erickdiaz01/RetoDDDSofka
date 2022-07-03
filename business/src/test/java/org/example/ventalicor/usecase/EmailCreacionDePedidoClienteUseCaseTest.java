package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.DatosMedioDePagoDeCliente;
import org.example.ventalicor.cliente.values.MedioDePagoId;
import org.example.ventalicor.cliente.values.TipoMedioDePago;
import org.example.ventalicor.pedido.DetallePedido;
import org.example.ventalicor.pedido.Sede;
import org.example.ventalicor.pedido.events.PedidoCreado;
import org.example.ventalicor.pedido.values.*;
import org.example.ventalicor.producto.values.ProductoId;
import org.example.ventalicor.usecase.service.EmailPedidoCreadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmailCreacionDePedidoClienteUseCaseTest {
    @Mock
    EmailPedidoCreadoService service;
    @InjectMocks
    EmailCreacionDePedidoClienteUseCase useCase;
    @Test
    void enviarMailPedidoCreado(){
        PedidoId pedidoId = PedidoId.of("PedidoN");
        ClienteId clienteId = ClienteId.of("Cliente1");
        Map<ProductoId, CantidadProductos> listaDetalle = new HashMap<>();
        listaDetalle.put(ProductoId.of("Prod1"),new CantidadProductos(5));
        listaDetalle.put(ProductoId.of("Prod2"),new CantidadProductos(2));
        Sede sede = new Sede(SedeId.of("Sede1"),new DireccionSede("Calle6Carrera80"),new NombreSede("Banderas"));
        ValorTotal valorTotal = new ValorTotal(50000);
        DetallePedido detallePedido = new DetallePedido(new DetalleDePedidoId(),listaDetalle,valorTotal);
        MedioDePago medioDePago = new MedioDePago(MedioDePagoId.of("Tarj1"),new DatosMedioDePagoDeCliente("1489"),new TipoMedioDePago(TipoMedioDePago.tipoMedioDePago.TARJETADEBITO));
        Descuento descuento = new Descuento(0.15);
        var event = new PedidoCreado(pedidoId,sede,detallePedido,clienteId,medioDePago,descuento);
        Mockito.doNothing().when(service).enviarEmail(pedidoId,"Su pedido ha sido creado con exito, con id PedidoN y valor total de 50000");
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance().syncExecutor(useCase,new TriggeredEvent<>(event)).orElseThrow().getDomainEvents();
        Mockito.verify(service).enviarEmail(pedidoId,"Su pedido ha sido creado con exito, con id PedidoN y valor total de 50000");
    }

}