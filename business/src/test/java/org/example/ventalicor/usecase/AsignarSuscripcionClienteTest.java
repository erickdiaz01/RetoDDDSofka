package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.Cliente;
import org.example.ventalicor.cliente.CuentaAplicacion;
import org.example.ventalicor.cliente.Suscripcion;
import org.example.ventalicor.cliente.commands.AsignarSuscripcionCommand;
import org.example.ventalicor.cliente.events.ClienteCreado;
import org.example.ventalicor.cliente.events.SuscripcionAsignada;
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
class AsignarSuscripcionClienteTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AsignarSuscripcionClienteUseCase useCase;

    @Test
    void asignarSuscripcionCliente(){
        CuentaAplicacionId cuentaAplicacionId= CuentaAplicacionId.of("Cuenta1");
        Suscripcion suscripcion = new Suscripcion(new SuscripcionId(),new TipoSuscripcion(TipoSuscripcion.tipo.PREMIUM));
        ClienteId clienteId = ClienteId.of("Cliente1");

        var command = new AsignarSuscripcionCommand(cuentaAplicacionId,clienteId,suscripcion);
        when(repository.getEventsBy(clienteId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events= UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //Asserts
        var event = (SuscripcionAsignada)events.get(0);
        Assertions.assertEquals("PREMIUM",event.getSuscripcion().getTipoSuscripcion().value());
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