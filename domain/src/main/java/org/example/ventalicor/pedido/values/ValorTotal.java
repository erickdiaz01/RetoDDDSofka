package org.example.ventalicor.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class ValorTotal implements ValueObject<Integer> {
    private final Integer valorTotal;

    public ValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public Integer value() {
        return valorTotal;
    }

    public ValorTotal cambiarValor(Integer valor){
        return new ValorTotal(valor);
    }
}
