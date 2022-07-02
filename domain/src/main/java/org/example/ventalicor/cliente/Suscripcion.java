package org.example.ventalicor.cliente;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.cliente.values.Beneficio;
import org.example.ventalicor.cliente.values.SuscripcionId;
import org.example.ventalicor.cliente.values.TipoSuscripcion;

import java.util.HashSet;
import java.util.Set;

public class Suscripcion extends Entity<SuscripcionId> {
   private TipoSuscripcion tipoSuscripcion;
   private Set<Beneficio> beneficios;

    public Suscripcion(SuscripcionId entityId, TipoSuscripcion tipoSuscripcion) {
        super(entityId);
        this.tipoSuscripcion = tipoSuscripcion;
        this.beneficios = new HashSet<>();
    }
    public void cambiarTipoDeSuscripcion(String suscripcion){
        this.tipoSuscripcion=tipoSuscripcion.cambiarTipo(TipoSuscripcion.tipo.valueOf(suscripcion));
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public Set<Beneficio> getBeneficios() {
        return beneficios;
    }
}
