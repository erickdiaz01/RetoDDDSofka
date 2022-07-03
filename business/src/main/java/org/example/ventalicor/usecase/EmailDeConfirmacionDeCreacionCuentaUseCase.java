package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.ventalicor.cliente.events.ClienteCreado;
import org.example.ventalicor.usecase.service.EmailCuentaCreadaService;

import java.util.List;

public class EmailDeConfirmacionDeCreacionCuentaUseCase extends UseCase<TriggeredEvent<ClienteCreado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ClienteCreado> clienteCreadoTriggeredEvent) {
        var event = clienteCreadoTriggeredEvent.getDomainEvent();

        var service = getService(EmailCuentaCreadaService.class).orElseThrow();

        String body = String.format("Su cuenta ha sido creada con exito, con id %s y tipo de suscripcion %s",event.getCuentaAplicacionId(),event.getTipoSuscripcion().value());
        service.enviarEmail(event.getCuentaAplicacionId(),body);

        emit().onResponse(new ResponseEvents(List.of()));
}}
