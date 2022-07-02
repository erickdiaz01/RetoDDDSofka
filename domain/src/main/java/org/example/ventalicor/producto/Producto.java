package org.example.ventalicor.producto;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.events.*;
import org.example.ventalicor.producto.values.*;

import java.util.List;

public class Producto extends AggregateEvent<ProductoId> {
    protected Categoria categoria;
    protected Fabricante fabricante;
    protected Precio precio;
    protected Referencia referencia;

    public Producto(ProductoId productoId, Categoria categoria, Fabricante fabricante, Precio precio, Referencia referencia) {
        super(productoId);
        appendChange(new ProductoCreado(categoria,fabricante,precio,referencia)).apply();
        subscribe(new ProductoEventChange(this));
    }
    private Producto(ProductoId productoId){
        super(productoId);
        subscribe(new ProductoEventChange(this));
    }
    public static Producto from(ProductoId productoId, List<DomainEvent> events){
        var producto = new Producto(productoId);
        events.forEach(producto::applyEvent);
        return producto;
    }
    public void cambiarPrecioProducto(ProductoId productoId,String moneda, Integer precio){
        appendChange(new PrecioDeProductoCambiado(productoId,moneda,precio)).apply();

    }
    public void cambiarNombreDeCategoriaProducto(CategoriaId categoriaId, String nombreCategoria){
        appendChange(new NombreDeCategoriaDeProductoCambiado(categoriaId,nombreCategoria)).apply();
    }
    public void cambiarEmbriaganteDeCategoria(CategoriaId categoriaId,Boolean embriaga){
        appendChange(new EmbriaganteCambiado(categoriaId,embriaga)).apply();
    }
    public void cambiarNombreDeFabricante(FabricanteId fabricanteId,String nombreFabricante){
        appendChange(new NombreDeFabricanteCambiado(fabricanteId,nombreFabricante)).apply();
    }
    public void cambiarPaisDeFabricante(FabricanteId fabricanteId,String paisFabricante){
        appendChange(new PaisDeFabricanteCambiado(fabricanteId,paisFabricante)).apply();
    }
    public void cambiarNombreDeReferencia(ProductoId productoId,ReferenciaId referenciaId,String nombreReferencia){
        appendChange(new NombreDeReferenciaCambiado(productoId,referenciaId,nombreReferencia)).apply();
    }

}

