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
            if(event.getMediosDePago().contains(event.getMedioDePago().getDatosMedioDePagoDeCliente().value())){
                throw new IllegalArgumentException("Ya tiene un medio de pago con estos datos");
            }
            cliente.mediosDePago.add(event.getMedioDePago());
        });
        apply((SuscripcionAsignada event)->{
            if(event.getCuentaAplicacionId()==null){
                throw new IllegalArgumentException("Debe tener una cuenta creada");
            }
            cliente.suscripcion= event.getSuscripcion();
        });
        apply((DireccionDeClienteCambiadaApp event)->{
            if(event.getCuentaAplicacionId()==null){
                throw new IllegalArgumentException("Debe tener una cuenta creada");
            }
            cliente.cuentaAplicacion.cambiarDireccionCliente(event.getNuevaDireccionCliente());

        });
        apply((TipoDeSuscripcionCambiada event)->{
            if(event.getSuscripcionId()==null){
                throw new IllegalArgumentException("Debe tener una suscripcion asignada");
            }
            cliente.suscripcion.cambiarTipoDeSuscripcion(String.valueOf(event.getNuevoTipo()));
        });

    }
}
