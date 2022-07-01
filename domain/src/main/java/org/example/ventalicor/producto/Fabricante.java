package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.producto.values.FabricanteId;

public class Fabricante extends Entity<FabricanteId> {
    public Fabricante(FabricanteId fabricanteId) {
        super(fabricanteId);
    }
}
