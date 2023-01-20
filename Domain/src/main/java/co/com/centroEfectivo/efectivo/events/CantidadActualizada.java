package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.sofka.domain.generic.DomainEvent;

public class CantidadActualizada extends DomainEvent {

    private final Cantidad cantidad;
    public CantidadActualizada(Cantidad cantidad) {
        super("co.com.centroEfectivo.efectivo.events.CantidadAgregada");
        this.cantidad = cantidad;
    }

    public Cantidad getCantidad() {return cantidad;}
}
