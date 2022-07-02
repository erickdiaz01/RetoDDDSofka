package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.producto.values.FabricanteId;
import org.example.ventalicor.producto.values.NombreFabricante;
import org.example.ventalicor.producto.values.Pais;

public class Fabricante extends Entity<FabricanteId> {
    private NombreFabricante nombreFabricante;
    private Pais pais;

    public Fabricante(FabricanteId fabricanteId, NombreFabricante nombreFabricante, Pais pais) {
        super(fabricanteId);
        this.nombreFabricante = nombreFabricante;
        this.pais = pais;
    }
    public void cambiarNombreFabricante(String nuevoNombre){
        this.nombreFabricante=nombreFabricante.cambiarNombre(nuevoNombre);
    }
    public void cambiarPaisFabricante(String nuevoPais){
        this.pais=pais.cambiarPais(nuevoPais);
    }

    public NombreFabricante getNombreFabricante() {
        return nombreFabricante;
    }

    public Pais getPais() {
        return pais;
    }
}
