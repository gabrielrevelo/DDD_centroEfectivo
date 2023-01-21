package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarCantidad extends Command {

    private final Cantidad cantidad;
    private final EfectivoId efectivoId;

    public ActualizarCantidad(EfectivoId efectivoId,Cantidad cantidad){

        this.efectivoId = efectivoId;
        this.cantidad = cantidad;
    }

    public EfectivoId getEfectivoId() {
        return efectivoId;
    }

    public Cantidad getCantidad() {return cantidad;}

}
