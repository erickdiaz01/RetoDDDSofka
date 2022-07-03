package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.ventalicor.cliente.events.ClienteCreado;
import org.example.ventalicor.cliente.values.*;
import org.example.ventalicor.usecase.service.EmailCuentaCreadaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailDeConfirmacionDeCreacionCuentaUseCaseTest {
@Mock
EmailCuentaCreadaService service;

@InjectMocks
    EmailDeConfirmacionDeCreacionCuentaUseCase useCase;

@Test
    void enviarEmail(){
    ClienteId clienteId = ClienteId.of("Cliente1");
    CuentaAplicacionId cuentaAplicacionId = CuentaAplicacionId.of("Cuenta1");
    DirecionCliente direcionCliente = new DirecionCliente("Carera88C");
    TelefonoCliente telefonoCliente = new TelefonoCliente("4733210");
    NombreCompletoCliente nombreCompletoCliente = new NombreCompletoCliente("Erick","Diaz");
    TipoSuscripcion tipoSuscripcion = new TipoSuscripcion(TipoSuscripcion.tipo.ESTANDAR);
    var event = new ClienteCreado(clienteId,cuentaAplicacionId,direcionCliente,telefonoCliente,nombreCompletoCliente,tipoSuscripcion);
    Mockito.doNothing().when(service).enviarEmail(cuentaAplicacionId,"Su cuenta ha sido creada con exito, con id Cuenta1 y tipo de suscripcion ESTANDAR");
    useCase.addServiceBuilder(new ServiceBuilder().addService(service));

    var events = UseCaseHandler.getInstance().syncExecutor(useCase,new TriggeredEvent<>(event)).orElseThrow().getDomainEvents();
    Mockito.verify(service).enviarEmail(cuentaAplicacionId,"Su cuenta ha sido creada con exito, con id Cuenta1 y tipo de suscripcion ESTANDAR");
    Assertions.assertEquals(0,events.size());
}
}