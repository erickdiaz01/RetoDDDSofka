package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.MedioDePago;
import org.example.ventalicor.cliente.commands.AgregarMedioDePagoCommand;
import org.example.ventalicor.cliente.events.ClienteCreado;
import org.example.ventalicor.cliente.events.MedioDePagoAgregado;
import org.example.ventalicor.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarMedioDePagoClienteUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarMedioDePagoClienteUseCase useCase;

    @Test
    void agregarMedioDePagoCliente(){
        //Arrange
        ClienteId clienteId = ClienteId.of("Cliente1");
        CuentaAplicacionId cuentaAplicacionId = CuentaAplicacionId.of("Cuenta1");
        MedioDePago medioDePago = new MedioDePago(MedioDePagoId.of("MedioP1"),new DatosMedioDePagoDeCliente("64454024"),new TipoMedioDePago(TipoMedioDePago.tipoMedioDePago.PSE));


        var command = new AgregarMedioDePagoCommand(clienteId,cuentaAplicacionId,medioDePago);
        when(repository.getEventsBy(clienteId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events= UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //Asserts
        var event = (MedioDePagoAgregado)events.get(0);
        Assertions.assertEquals(1,event.getMediosDePago().size());
        Assertions.assertEquals("PSE",event.getMedioDePago().getTipoMedioDePago().value());
    }

    private List<DomainEvent> history() {
        ClienteId clienteId = ClienteId.of("Cliente1");
        CuentaAplicacionId cuentaAplicacionId = CuentaAplicacionId.of("Cuenta1");
        DirecionCliente direcionCliente = new DirecionCliente("Carera88C");
        TelefonoCliente telefonoCliente = new TelefonoCliente("4733210");
        NombreCompletoCliente nombreCompletoCliente = new NombreCompletoCliente("Erick","Diaz");
        TipoSuscripcion tipoSuscripcion = new TipoSuscripcion(TipoSuscripcion.tipo.ESTANDAR);
        return List.of(new ClienteCreado(clienteId,cuentaAplicacionId,direcionCliente,telefonoCliente,nombreCompletoCliente,tipoSuscripcion));
    }

}