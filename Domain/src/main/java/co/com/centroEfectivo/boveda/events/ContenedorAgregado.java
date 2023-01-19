package co.com.centroEfectivo.boveda.events;

import co.com.centroEfectivo.boveda.values.CapacidadActual;
import co.com.centroEfectivo.boveda.values.CapacidadMaxima;
import co.com.centroEfectivo.boveda.values.ContenedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class ContenedorAgregado extends DomainEvent {


    private final ContenedorId contenedorId;
    private final CapacidadMaxima capacidadMaxima;
    private final CapacidadActual capacidadActual;

    public ContenedorAgregado(ContenedorId contenedorId, CapacidadMaxima capacidadMaxima, CapacidadActual capacidadActual) {
        super("co.com.centroEfectivo.boveda.events.contenedorAgregado");
        this.contenedorId = contenedorId;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
    }

    public ContenedorId getContenedorId(){
        return contenedorId;
    }

    public CapacidadActual getCapacidadActual() {
        return capacidadActual;
    }

    public CapacidadMaxima getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
