package org.example.ventalicor.pedido;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.pedido.values.DireccionSede;
import org.example.ventalicor.pedido.values.DomiciliarioId;
import org.example.ventalicor.pedido.values.NombreSede;
import org.example.ventalicor.pedido.values.SedeId;

public class Sede extends Entity<SedeId> {
    private DireccionSede direccionSede;
    private NombreSede nombreSede;

    public Sede(SedeId sedeId, DireccionSede direccionSede, NombreSede nombreSede) {
        super(sedeId);
        this.direccionSede = direccionSede;
        this.nombreSede = nombreSede;
    }

    public void cambiarNombreSede(String nombre){
        this.nombreSede=nombreSede.cambiarNombre(nombre);
    }
}
