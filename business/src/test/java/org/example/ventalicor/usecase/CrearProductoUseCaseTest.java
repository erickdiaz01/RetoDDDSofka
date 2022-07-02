package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.ventalicor.producto.Categoria;
import org.example.ventalicor.producto.Fabricante;
import org.example.ventalicor.producto.Producto;
import org.example.ventalicor.producto.Referencia;
import org.example.ventalicor.producto.commands.CrearProductoCommand;
import org.example.ventalicor.producto.events.ProductoCreado;
import org.example.ventalicor.producto.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearProductoUseCaseTest {
@InjectMocks
    CrearProductoUseCase useCase;
@Test
    public void crearProducto(){
    //Arrange
    ProductoId productoId = ProductoId.of("Producto1");
    Categoria categoria = new Categoria(CategoriaId.of("Cat1"),new NombreCategoria("Dulces"),new Embriagante(false));
    Fabricante fabricante = new Fabricante(FabricanteId.of("Fabr1"),new NombreFabricante("Colombina"),new Pais("Colombia"));
    Precio precio = new Precio("COP",500);
    Referencia referencia = new Referencia(ReferenciaId.of("Bomb1"),new NombreReferencia("Bombombun"));

    var command = new CrearProductoCommand(productoId,categoria,fabricante,precio,referencia);

    //Act
    var events = UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();
    //Assert
    var event = (ProductoCreado)events.get(0);
    Assertions.assertEquals("Dulces",event.getCategoria().getNombreCategoria().value());
    Assertions.assertEquals(false,event.getCategoria().getEmbriagante().value());
    Assertions.assertEquals("Colombina",event.getFabricante().getNombreFabricante().value());
    Assertions.assertEquals(500,event.getPrecio().value().costo());
}

}