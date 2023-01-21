package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.domain.generic.DomainEvent;

public class CantidadActualizada extends DomainEvent {

    private final EfectivoId efectivoId;
    private final Cantidad cantidad;
    public CantidadActualizada(EfectivoId efectivoId,Cantidad cantidad) {
        super("co.com.centroEfectivo.efectivo.events.CantidadAgregada");
        this.efectivoId = efectivoId;
        this.cantidad = cantidad;
    }

    public EfectivoId getEfectivoId() {return efectivoId;}

    public Cantidad getCantidad() {return cantidad;}
}
