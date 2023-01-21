package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.centroEfectivo.tula.values.Fecha;
import co.com.sofka.domain.generic.Command;

public class ActualizarUbicacion extends Command {

    private final EfectivoId efectivoId;
    private final Ubicacion ubicacion;

    public ActualizarUbicacion(EfectivoId efectivoId,Ubicacion ubicacion){
        this.efectivoId = efectivoId;
        this.ubicacion = ubicacion;
    }

    public EfectivoId getEfectivoId() {return efectivoId;}

    public Ubicacion getUbicacion() {return ubicacion;}
}
