package co.com.centroEfectivo.boveda;

import co.com.centroEfectivo.boveda.entities.Contenedor;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.events.CapacidadActualDeContenedorActualizada;
import co.com.centroEfectivo.boveda.events.ContenedorAgregado;
import co.com.centroEfectivo.boveda.events.EfectivoAsociado;
import co.com.centroEfectivo.boveda.values.*;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
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

    public static Boveda from(BovedaId bovedaId, List<DomainEvent> events){
        var boveda = new Boveda(bovedaId);
        events.forEach(boveda::applyEvent);
        return boveda;
    }

    public void agregarContenedor(BovedaId bovedaId,ContenedorId contenedorId, CapacidadMaxima capacidadMaxima, CapacidadActual capacidadActual){
        Objects.requireNonNull(contenedorId);
        Objects.requireNonNull(capacidadActual);
        Objects.requireNonNull(capacidadMaxima);
        Objects.requireNonNull(bovedaId);
        appendChange(new ContenedorAgregado(bovedaId,contenedorId,capacidadMaxima,capacidadActual)).apply();
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

    public void asociarEfectivoId(BovedaId bovedaId,EfectivoId efectivoId){
        appendChange(new EfectivoAsociado(bovedaId,efectivoId)).apply();
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
