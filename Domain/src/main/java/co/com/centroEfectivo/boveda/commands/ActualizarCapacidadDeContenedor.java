package co.com.centroEfectivo.boveda.commands;

import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.boveda.values.CapacidadActual;
import co.com.centroEfectivo.boveda.values.ContenedorId;
import co.com.sofka.domain.generic.Command;

public class ActualizarCapacidadDeContenedor extends Command {

    private final BovedaId bovedaId;
    private final ContenedorId contenedorId;
    private final CapacidadActual capacidadActual;

    public ActualizarCapacidadDeContenedor(BovedaId bovedaId,ContenedorId contenedorId,final CapacidadActual capacidadActual) {
        this.bovedaId = bovedaId;
        this.capacidadActual = capacidadActual;
        this.contenedorId = contenedorId;
    }

    public ContenedorId getContenedorId() {
        return contenedorId;
    }

    public CapacidadActual getCapacidadActual() {
        return capacidadActual;
    }

    public BovedaId getBovedaId() {
        return bovedaId;
    }
}
