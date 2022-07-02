package org.example.ventalicor.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.cliente.events.*;
import org.example.ventalicor.cliente.values.*;

import java.util.List;
import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {
    protected CuentaAplicacion cuentaAplicacion;
    protected Set<MedioDePago> mediosDePago;
    protected Suscripcion suscripcion;

    public Cliente(ClienteId clienteId, CuentaAplicacionId cuentaAplicacionId, TelefonoCliente telefonoCliente, NombreCompletoCliente nombreCompletoCliente, DirecionCliente direccionCliente,TipoSuscripcion tipoSuscripcion) {
        super(clienteId);
        appendChange(new ClienteCreado(cuentaAplicacionId,direccionCliente,telefonoCliente,nombreCompletoCliente,tipoSuscripcion)).apply();
        subscribe(new ClienteEventChange(this));
    }
    private Cliente(ClienteId clienteId){
        super(clienteId);
        subscribe(new ClienteEventChange(this));
    }
    public static Cliente from (ClienteId clienteId, List<DomainEvent> events){
        var cliente = new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }
   public void agregarMedioDePago(CuentaAplicacionId cuentaAplicacionId,MedioDePago medioDePago){
        appendChange(new MedioDePagoAgregado(cuentaAplicacionId,medioDePago)).apply();
   }
   public void asignarSuscripcion(CuentaAplicacionId cuentaAplicacionId,Suscripcion suscripcion){
        appendChange(new SuscripcionAsignada(cuentaAplicacionId,suscripcion)).apply();
   }
   public void cambiarDireccionClienteCuentaApp(CuentaAplicacionId cuentaAplicacionId,String nuevaDireccionCliente){
        appendChange(new DireccionDeClienteCambiadaApp(cuentaAplicacionId,nuevaDireccionCliente)).apply();
   }
   public void cambiarTipoSuscripcionCliente(SuscripcionId suscripcionId,TipoSuscripcion nuevoTipo){
       appendChange(new TipoDeSuscripcionCambiada(suscripcionId,nuevoTipo)).apply();
   }
   public void cambiarTelefonoClienteCuentaApp(CuentaAplicacionId cuentaAplicacionId,String nuevoTelefono){
        appendChange(new TelefonoDeClienteCambiadoApp(cuentaAplicacionId,nuevoTelefono)).apply();
   }


}
