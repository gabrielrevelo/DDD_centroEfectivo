package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.entities.Cajero;
import co.com.centroEfectivo.revision.entities.Reporte;
import co.com.centroEfectivo.revision.events.CajeroAgregado;
import co.com.centroEfectivo.revision.events.ReporteAgregado;
import co.com.centroEfectivo.revision.events.RevisionCreada;
import co.com.centroEfectivo.revision.events.TulaAsociada;
import co.com.centroEfectivo.revision.values.*;
import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Revision extends AggregateEvent<RevisionId> {
    protected TulaId tulaId;
    protected Reporte reporte;
    protected Cajero cajero;
    protected Cubiculo cubiculo;

    public Revision(RevisionId revisionId, Cubiculo cubiculo) {
        super(revisionId);
        appendChange(new RevisionCreada(cubiculo)).apply();
    }

    private Revision (RevisionId revisionId) {
        super(revisionId);
        subscribe(new RevisionChange(this));
    }

    public static Revision from(RevisionId revisionId, List<DomainEvent> events) {
        var revision = new Revision(revisionId);
        events.forEach(revision::applyEvent);
        return revision;
    }

    public void agregarCajero(CajeroId cajeroId, Nombre nombre) {
        Objects.requireNonNull(cajeroId);
        Objects.requireNonNull(nombre);
        appendChange(new CajeroAgregado(cajeroId, nombre)).apply();
    }

    public void agregarReporte(ReporteId reporteId, Fecha fecha, Novedad novedad) {
        Objects.requireNonNull(reporteId);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(novedad);
        appendChange(new ReporteAgregado(reporteId, fecha, novedad)).apply();
    }

    public void asociarTula(TulaId tulaId) {
        appendChange(new TulaAsociada(tulaId)).apply();
    }

    public TulaId tulaId() {
        return tulaId;
    }

    public Reporte reporte() {
        return reporte;
    }

    public Cajero cajero() {
        return cajero;
    }

    public Cubiculo cubiculo() {
        return cubiculo;
    }
}
