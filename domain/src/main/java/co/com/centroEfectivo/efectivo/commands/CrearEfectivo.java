package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.entities.Cliente;
import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.domain.generic.Command;

public class CrearEfectivo extends Command {


    private final EfectivoId efectivoId;

    private final Cantidad cantidad;
    private final Ubicacion ubicacion;

    public CrearEfectivo(EfectivoId efectivoId, Cantidad cantidad, Ubicacion ubicacion) {
        this.efectivoId = efectivoId;

        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public EfectivoId getEfectivoId() {return efectivoId;}


    public Cantidad getCantidad() {return cantidad;}

    public Ubicacion getUbicacion() {return ubicacion;}
}
