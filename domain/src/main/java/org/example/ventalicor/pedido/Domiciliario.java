package org.example.ventalicor.pedido;

import co.com.sofka.domain.generic.Entity;

import org.example.ventalicor.pedido.values.DomiciliarioId;
import org.example.ventalicor.pedido.values.NombreDomiciliario;
import org.example.ventalicor.pedido.values.TelefonoDomiciliario;

public class Domiciliario extends Entity<DomiciliarioId> {
    private NombreDomiciliario nombreDomiciliario;
    private TelefonoDomiciliario telefonoDomiciliario;

    public Domiciliario(DomiciliarioId entityId, NombreDomiciliario nombreDomiciliario, TelefonoDomiciliario telefonoDomiciliario) {
        super(entityId);
        this.nombreDomiciliario = nombreDomiciliario;
        this.telefonoDomiciliario = telefonoDomiciliario;
    }
    public void cambiarTelefonoDomiciliario(String telefono){
        this.telefonoDomiciliario=telefonoDomiciliario.cambiarTelefono(telefono);
    }

    public NombreDomiciliario getNombreDomiciliario() {
        return nombreDomiciliario;
    }

    public TelefonoDomiciliario getTelefonoDomiciliario() {
        return telefonoDomiciliario;
    }
}
