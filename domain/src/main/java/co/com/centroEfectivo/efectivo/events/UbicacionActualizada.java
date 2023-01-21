package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public class UbicacionActualizada extends DomainEvent {

    private final Ubicacion ubicacion;

    public UbicacionActualizada(Ubicacion ubicacion) {

        super("co.com.centroEfectivo.efectivo.events.UbicacionAgregada");

        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {return ubicacion;}
}
