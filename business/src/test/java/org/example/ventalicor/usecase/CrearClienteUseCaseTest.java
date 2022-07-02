package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.ventalicor.cliente.commands.CrearClienteCommand;
import org.example.ventalicor.cliente.events.ClienteCreado;
import org.example.ventalicor.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearClienteUseCaseTest {
@InjectMocks
    CrearClienteUseCase useCase;

@Test
    public void crearCliente(){
    //Arrange

    ClienteId clienteId = ClienteId.of("Cliente1");
    DirecionCliente direcionCliente = new DirecionCliente("Carera88C");
    TelefonoCliente telefonoCliente = new TelefonoCliente("4733210");
    NombreCompletoCliente nombreCompletoCliente = new NombreCompletoCliente("Erick","Diaz");
    TipoSuscripcion tipoSuscripcion = new TipoSuscripcion(TipoSuscripcion.tipo.ESTANDAR);
    var command= new CrearClienteCommand(direcionCliente,telefonoCliente,nombreCompletoCliente,tipoSuscripcion,clienteId);

    //Act
    var events = UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();


    //Assert
    var event = (ClienteCreado)events.get(0);
    Assertions.assertEquals("Erick Diaz",event.getNombreCompletoCliente().value());
    Assertions.assertEquals("4733210",event.getTelefonoCliente().value());
}
}