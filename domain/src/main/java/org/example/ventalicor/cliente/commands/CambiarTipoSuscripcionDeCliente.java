package org.example.ventalicor.cliente.commands;

import co.com.sofka.domain.generic.Command;
import org.example.ventalicor.cliente.values.SuscripcionId;
import org.example.ventalicor.cliente.values.TipoSuscripcion;

public class CambiarTipoSuscripcionDeCliente extends Command {
    private final SuscripcionId suscripcionId;
    private final TipoSuscripcion tipoSuscripcion;


    public CambiarTipoSuscripcionDeCliente(SuscripcionId suscripcionId, TipoSuscripcion tipoSuscripcion) {
        this.suscripcionId = suscripcionId;
        this.tipoSuscripcion = tipoSuscripcion;
    }
}
