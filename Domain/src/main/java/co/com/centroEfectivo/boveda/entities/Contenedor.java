package co.com.centroEfectivo.boveda.entities;

import co.com.centroEfectivo.boveda.values.CapacidadActual;
import co.com.centroEfectivo.boveda.values.CapacidadMaxima;
import co.com.centroEfectivo.boveda.values.ContenedorId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;


public class Contenedor extends Entity<ContenedorId> {

    private  CapacidadMaxima capacidadMaxima;
    private  CapacidadActual capacidadActual;


    public Contenedor(ContenedorId contenedorId, CapacidadMaxima capacidadMaxima, CapacidadActual capacidadActual) {
        super(contenedorId);
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
    }


    public void actualizarCapacidadActual(CapacidadActual capacidadActual){
        this.capacidadActual = Objects.requireNonNull(capacidadActual);
    }
    public CapacidadMaxima capacidadMaxima(){
        return capacidadMaxima;
    }

    public CapacidadActual capacidadActual(){
        return capacidadActual;
    }
}
