package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.tula.entities.Planilla;
import co.com.centroEfectivo.tula.events.EfectivoAsociado;
import co.com.centroEfectivo.tula.events.EstadoActualizado;
import co.com.centroEfectivo.tula.events.PlanillaAgregada;
import co.com.centroEfectivo.tula.events.TulaCreada;
import co.com.centroEfectivo.tula.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Tula extends AggregateEvent<TulaId> {
    protected EfectivoId efectivoId;
    protected Estado estado;
    protected Planilla planilla;

    public Tula(TulaId tulaId, Estado estado) {
        super(tulaId);
        appendChange(new TulaCreada(estado)).apply();
    }

    private Tula(TulaId tulaId) {
        super(tulaId);
        subscribe(new TulaChange(this));
    }

    public static Tula from(TulaId tulaId, List<DomainEvent> events) {
       var tula = new Tula(tulaId);
       events.forEach(tula::applyEvent);
       return tula;
    }

    public void agregarPlanilla(PlanillaId planillaId, Fecha fecha, Direccion direccion) {
        Objects.requireNonNull(planillaId);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(direccion);
        appendChange(new PlanillaAgregada(planillaId, fecha, direccion)).apply();
    }

    public void asociarEfectivo(EfectivoId efectivoId) {
        appendChange(new EfectivoAsociado(efectivoId)).apply();
    }

    public void actualizarEstado(Estado estado) {
        appendChange(new EstadoActualizado(estado)).apply();
    }

    public Estado estado() {
        return estado;
    }

    public Planilla planilla() {
        return planilla;
    }
}
