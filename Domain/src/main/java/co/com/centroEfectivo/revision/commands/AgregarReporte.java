package co.com.centroEfectivo.revision.commands;

import co.com.centroEfectivo.revision.values.Fecha;
import co.com.centroEfectivo.revision.values.Novedad;
import co.com.centroEfectivo.revision.values.ReporteId;
import co.com.sofka.domain.generic.Command;

public class AgregarReporte extends Command {
    private final ReporteId reporteId;
    private final Fecha fecha;
    private final Novedad novedad;

    public AgregarReporte(ReporteId reporteId, Fecha fecha, Novedad novedad) {
        this.reporteId = reporteId;
        this.fecha = fecha;
        this.novedad = novedad;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Novedad getNovedad() {
        return novedad;
    }
}
