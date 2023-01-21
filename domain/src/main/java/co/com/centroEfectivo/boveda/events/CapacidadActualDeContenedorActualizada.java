package co.com.centroEfectivo.boveda.events;

import co.com.centroEfectivo.boveda.values.CapacidadActual;
import co.com.centroEfectivo.boveda.values.ContenedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadActualDeContenedorActualizada extends DomainEvent {
    private final ContenedorId contenedorId;
    private final CapacidadActual capacidadActual;

    public CapacidadActualDeContenedorActualizada(ContenedorId contenedorId, CapacidadActual capacidadActual) {
        super("co.com.centroEfectivo.boveda.events.CapacidadActualDeContenedorActualizada");
        this.contenedorId = contenedorId;
        this.capacidadActual = capacidadActual;
    }

    public CapacidadActual getCapacidadActual() {
        return capacidadActual;
    }

    public ContenedorId getContenedorId() {
        return contenedorId;
    }
}
