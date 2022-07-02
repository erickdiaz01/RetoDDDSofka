package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.EventChange;
import org.example.ventalicor.producto.events.*;

public class ProductoEventChange extends EventChange {
    public ProductoEventChange(Producto producto) {
        apply((ProductoCreado event) -> {
            producto.categoria = event.getCategoria();
            producto.fabricante = event.getFabricante();
            producto.referencia = event.getReferencia();
            producto.precio = event.getPrecio();
        });
        apply((PrecioDeProductoCambiado event) -> {
            producto.precio.cambiarPrecio(event.getMoneda(), event.getPrecio());
        });
        apply((NombreDeCategoriaDeProductoCambiado event) -> {
            producto.categoria.cambiarNombreCategoria(event.getNombreCategoria());
        });
        apply((EmbriaganteCambiado event) -> {
            producto.categoria.cambiarEmbriagante(event.getEmbriaga());
        });
        apply((NombreDeFabricanteCambiado event) -> {
            producto.fabricante.cambiarNombreFabricante(event.getNombreFabricante());
        });
        apply((PaisDeFabricanteCambiado event) -> {
            producto.fabricante.cambiarPaisFabricante(event.getPaisFabricante());
        });
apply((NombreDeReferenciaCambiado event)->{
    producto.referencia.cambiarNombreReferencia(event.getNombreReferencia());
});


    }
}
