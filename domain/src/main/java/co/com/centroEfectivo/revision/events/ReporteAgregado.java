package co.com.centroEfectivo.revision.events;

import co.com.centroEfectivo.revision.values.Fecha;
import co.com.centroEfectivo.revision.values.Novedad;
import co.com.centroEfectivo.revision.values.ReporteId;
import co.com.sofka.domain.generic.DomainEvent;

public class ReporteAgregado extends DomainEvent {
    private final ReporteId reporteId;
    private final Fecha fecha;
    private final Novedad novedad;

    public ReporteAgregado(ReporteId reporteId, Fecha fecha, Novedad novedad) {
        super("centroEfectivo.revision.reporteagregado");
        this.reporteId = reporteId;
        this.fecha = fecha;
        this.novedad = novedad;
    }

    public ReporteId getReporteId() {
        return  reporteId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Novedad getNovedad() {
        return novedad;
    }
}
