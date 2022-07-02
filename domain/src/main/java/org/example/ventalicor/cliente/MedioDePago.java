package org.example.ventalicor.cliente;

import co.com.sofka.domain.generic.Entity;
import org.example.ventalicor.cliente.values.DatosMedioDePagoDeCliente;
import org.example.ventalicor.cliente.values.MedioDePagoId;
import org.example.ventalicor.cliente.values.TipoMedioDePago;

public class MedioDePago extends Entity<MedioDePagoId> {
    private DatosMedioDePagoDeCliente datosMedioDePagoDeCliente;
    private TipoMedioDePago tipoMedioDePago;

    public MedioDePago(MedioDePagoId medioDePagoId, DatosMedioDePagoDeCliente datosMedioDePagoDeCliente, TipoMedioDePago tipoMedioDePago) {
        super(medioDePagoId);
        this.datosMedioDePagoDeCliente = datosMedioDePagoDeCliente;
        this.tipoMedioDePago = tipoMedioDePago;
    }

    public void cambiarDatosMedioDePago(String datosMedioDePago){
        this.datosMedioDePagoDeCliente=datosMedioDePagoDeCliente.cambiarDatosMedioDePago(datosMedioDePago);
    }

    public DatosMedioDePagoDeCliente getDatosMedioDePagoDeCliente() {
        return datosMedioDePagoDeCliente;
    }

    public TipoMedioDePago getTipoMedioDePago() {
        return tipoMedioDePago;
    }
}
