package org.example.ventalicor.pedido.commands;

import co.com.sofka.domain.generic.Command;

public class CambiarNombreDeSedeCommand extends Command {
    private final String nombreSede;

    public CambiarNombreDeSedeCommand(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }
}
