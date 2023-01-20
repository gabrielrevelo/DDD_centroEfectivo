package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.sofka.domain.generic.Command;

public class ActualizarCantidad extends Command {

    private final Cantidad cantidad;

    public ActualizarCantidad(Cantidad cantidad){
        this.cantidad = cantidad;
    }

    public Cantidad getCantidad() {return cantidad;}

}
