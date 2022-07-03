package org.example.ventalicor.usecase.service;

import org.example.ventalicor.cliente.values.CuentaAplicacionId;
import org.example.ventalicor.pedido.values.PedidoId;

public interface EmailPedidoCreadoService {
    void enviarEmail(PedidoId pedidoId, String body);

}
