package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.values.ClienteId;
import org.example.ventalicor.cliente.values.DatosMedioDePagoDeCliente;
import org.example.ventalicor.cliente.values.MedioDePagoId;
import org.example.ventalicor.cliente.values.TipoMedioDePago;
import org.example.ventalicor.pedido.DetallePedido;
import org.example.ventalicor.pedido.Sede;
import org.example.ventalicor.pedido.commands.AsignarDescuentoCommand;
import org.example.ventalicor.pedido.events.DescuentoAsignado;
import org.example.ventalicor.pedido.events.PedidoCreado;
import org.example.ventalicor.pedido.values.*;
import org.example.ventalicor.producto.values.ProductoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarDescuentoUseCaseTest {
@Mock
    DomainEventRepository repository;
@InjectMocks
    AsignarDescuentoUseCase useCase;

@Test
    void asignarDescuento(){
    //ARRANGE
    PedidoId pedidoId = PedidoId.of("Pedido1");
    Descuento descuento = new Descuento(0.3);
    var command= new AsignarDescuentoCommand(pedidoId,descuento);

    when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
    useCase.addRepository(repository);

    //ACT
    var events= UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

    //Asserts
    var event = (DescuentoAsignado)events.get(0);
    Assertions.assertEquals(0.3,event.getDescuento().value());
}

    private List<DomainEvent> history() {
        PedidoId pedidoId = PedidoId.of("PedidoN");
        Map<ProductoId, CantidadProductos> listaDetalle = new HashMap<>();
        listaDetalle.put(ProductoId.of("Prod1"),new CantidadProductos(5));
        listaDetalle.put(ProductoId.of("Prod2"),new CantidadProductos(2));

        Sede sede = new Sede(SedeId.of("Sede1"),new DireccionSede("Calle6Carrera80"),new NombreSede("Banderas"));
        ValorTotal valorTotal = new ValorTotal(50000);
        DetallePedido detallePedido = new DetallePedido(new DetalleDePedidoId(),listaDetalle,valorTotal);
        MedioDePago medioDePago = new MedioDePago(MedioDePagoId.of("Tarj1"),new DatosMedioDePagoDeCliente("1489"),new TipoMedioDePago(TipoMedioDePago.tipoMedioDePago.TARJETADEBITO));
        Descuento descuento = new Descuento(0.15);
        return List.of(new PedidoCreado(pedidoId,sede,detallePedido, ClienteId.of("Client1"),medioDePago,descuento));
    }
}