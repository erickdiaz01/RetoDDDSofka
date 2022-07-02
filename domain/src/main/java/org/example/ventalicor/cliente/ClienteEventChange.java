package org.example.ventalicor.cliente;

import co.com.sofka.domain.generic.EventChange;
import org.example.ventalicor.cliente.events.*;
import org.example.ventalicor.cliente.values.SuscripcionId;

import java.util.HashSet;

public class ClienteEventChange extends EventChange {
    //TODO:APLICAR REGLAS DE NEGOCIO CON LOS ID Y LOS VALORES
    public ClienteEventChange(Cliente cliente) {
        apply((ClienteCreado event)->{
            cliente.cuentaAplicacion=new CuentaAplicacion(event.getCuentaAplicacionId(),event.getDirecionCliente(),event.getTelefonoCliente(),event.getNombreCompletoCliente());
            cliente.mediosDePago=new HashSet<>();
            cliente.suscripcion=new Suscripcion(new SuscripcionId(),event.getTipoSuscripcion());
        });
        apply((MedioDePagoAgregado event)->{
            cliente.mediosDePago.add(event.getMedioDePago());
        });
        apply((SuscripcionAsignada event)->{
            cliente.suscripcion= event.getSuscripcion();
        });
        apply((DireccionDeClienteCambiadaApp event)->{
            cliente.cuentaAplicacion.cambiarDireccionCliente(event.getNuevaDireccionCliente());

        });
        apply((TipoDeSuscripcionCambiada event)->{
            cliente.suscripcion.cambiarTipoDeSuscripcion(String.valueOf(event.getNuevoTipo()));
        });

    }
}
