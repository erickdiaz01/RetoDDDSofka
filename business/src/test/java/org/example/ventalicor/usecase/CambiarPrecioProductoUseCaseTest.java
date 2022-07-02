package org.example.ventalicor.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.ventalicor.producto.Categoria;
import org.example.ventalicor.producto.Fabricante;
import org.example.ventalicor.producto.Referencia;
import org.example.ventalicor.producto.commands.CambiarPrecioDeProductoCommand;
import org.example.ventalicor.producto.events.PrecioDeProductoCambiado;
import org.example.ventalicor.producto.events.ProductoCreado;
import org.example.ventalicor.producto.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarPrecioProductoUseCaseTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    CambiarPrecioProductoUseCase useCase;

    @Test
    void cambiarPrecioProducto(){
        ProductoId productoId = ProductoId.of("Producto1");
        String moneda = "USD";
        Integer costo = 10;

        var command = new CambiarPrecioDeProductoCommand(productoId,moneda,costo);
        when(repository.getEventsBy(productoId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance().syncExecutor(useCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //Asserts
        var event = (PrecioDeProductoCambiado)events.get(0);
        Assertions.assertEquals(10,event.getPrecio());
        Assertions.assertEquals("USD",event.getMoneda());
    }

    private List<DomainEvent> history() {
        ProductoId productoId = ProductoId.of("Producto1");
        Categoria categoria = new Categoria(CategoriaId.of("Cat1"),new NombreCategoria("Dulces"),new Embriagante(false));
        Fabricante fabricante = new Fabricante(FabricanteId.of("Fabr1"),new NombreFabricante("Colombina"),new Pais("Colombia"));
        Precio precio = new Precio("COP",500);
        Referencia referencia = new Referencia(ReferenciaId.of("Bomb1"),new NombreReferencia("Bombombun"));
       return List.of(new ProductoCreado(categoria,fabricante,precio,referencia));
    }

}