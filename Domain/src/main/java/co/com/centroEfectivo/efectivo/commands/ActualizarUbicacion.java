package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.domain.generic.Command;

public class ActualizarUbicacion extends Command {

    private final Ubicacion ubicacion;

    public ActualizarUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {return ubicacion;}
}
