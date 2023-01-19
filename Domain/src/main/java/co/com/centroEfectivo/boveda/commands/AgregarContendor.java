package co.com.centroEfectivo.boveda.commands;

import co.com.centroEfectivo.boveda.values.CapacidadActual;
import co.com.centroEfectivo.boveda.values.CapacidadMaxima;
import co.com.centroEfectivo.boveda.values.ContenedorId;
import co.com.sofka.domain.generic.Command;

public class AgregarContendor extends Command {

    private final ContenedorId contenedorId;
    private final CapacidadMaxima capacidadMaxima;
    private final CapacidadActual capacidadActual;

    public AgregarContendor(ContenedorId contenedorId, CapacidadMaxima capacidadMaxima, CapacidadActual capacidadActual) {
        this.contenedorId = contenedorId;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
    }

    public CapacidadActual getCapacidadActual() {
        return capacidadActual;
    }

    public ContenedorId getContenedorId() {
        return contenedorId;
    }

    public CapacidadMaxima getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
