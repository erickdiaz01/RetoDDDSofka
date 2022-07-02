package org.example.ventalicor.cliente;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.cliente.values.CuentaAplicacionId;
import org.example.ventalicor.cliente.values.DirecionCliente;
import org.example.ventalicor.cliente.values.NombreCompletoCliente;
import org.example.ventalicor.cliente.values.TelefonoCliente;

public class CuentaAplicacion extends Entity<CuentaAplicacionId> {
    private DirecionCliente direcionCliente;
    private TelefonoCliente telefonoCliente;
    private NombreCompletoCliente nombreCompletoCliente;

    public CuentaAplicacion(CuentaAplicacionId cuentaAplicacionId, DirecionCliente direcionCliente, TelefonoCliente telefonoCliente, NombreCompletoCliente nombreCompletoCliente) {
        super(cuentaAplicacionId);
        this.direcionCliente = direcionCliente;
        this.telefonoCliente = telefonoCliente;
        this.nombreCompletoCliente = nombreCompletoCliente;
    }
    public void cambiarDireccionCliente(String direccion){
        this.direcionCliente= direcionCliente.cambiarDireccion(direccion);

    }
    public void cambiarTelefonoCliente(String telefono){
        this.telefonoCliente= telefonoCliente.cambiarTelefono(telefono);
    }

}
