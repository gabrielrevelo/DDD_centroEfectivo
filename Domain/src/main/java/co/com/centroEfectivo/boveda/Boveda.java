package co.com.centroEfectivo.boveda;

import co.com.centroEfectivo.boveda.entities.Contenedor;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.events.CapacidadActualDeContenedorActualizada;
import co.com.centroEfectivo.boveda.events.ContenedorAgregado;
import co.com.centroEfectivo.boveda.events.EfectivoAsociado;
import co.com.centroEfectivo.boveda.values.*;
import co.com.sofka.domain.generic.AggregateEvent;


import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Boveda extends AggregateEvent<BovedaId> {

    protected EfectivoTotal efectivoTotal;
    protected EfectivoId efectivoId;

    protected Set<Contenedor> contenedores;


    public Boveda(BovedaId bovedaId,EfectivoTotal efectivoTotal) {
        super(bovedaId);
        appendChange(new BovedaCreada(efectivoTotal)).apply();
    }

    private Boveda(BovedaId bovedaId) {
        super(bovedaId);
        subscribe(new BovedaChange(this));

    }

    public void agregarContenedor(ContenedorId contenedorId, CapacidadMaxima capacidadMaxima, CapacidadActual capacidadActual){
        Objects.requireNonNull(contenedorId);
        Objects.requireNonNull(capacidadActual);
        Objects.requireNonNull(capacidadMaxima);
        appendChange(new ContenedorAgregado(contenedorId,capacidadMaxima,capacidadActual)).apply();
    }

    public void actualizarCapacidadActualDeUnContenedor(ContenedorId contenedorId,CapacidadActual capacidadActual){
        appendChange(new CapacidadActualDeContenedorActualizada(contenedorId,capacidadActual)).apply();
    }

    protected Optional<Contenedor> getContenedorPorId(ContenedorId contenedorId){
        return contenedores()
                .stream()
                .filter(devolucion -> devolucion.identity().equals(contenedorId))
                .findFirst();
    }

    public void asociarEfectivoId(EfectivoId efectivoId){
        appendChange(new EfectivoAsociado(efectivoId)).apply();
    }


    public EfectivoTotal efectivoTotal(){
        return efectivoTotal;
    }

    public EfectivoId efectivoId(){
        return efectivoId;
    }

    public Set<Contenedor> contenedores(){
        return contenedores;
    }

}
