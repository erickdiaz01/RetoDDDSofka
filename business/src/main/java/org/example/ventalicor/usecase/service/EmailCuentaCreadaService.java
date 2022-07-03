package org.example.ventalicor.usecase.service;


import org.example.ventalicor.cliente.values.CuentaAplicacionId;

public interface EmailCuentaCreadaService {
    void enviarEmail(CuentaAplicacionId cuentaAplicacionId, String body);
}
