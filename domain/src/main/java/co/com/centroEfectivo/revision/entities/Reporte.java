package co.com.centroEfectivo.revision.entities;

import co.com.centroEfectivo.revision.values.Fecha;
import co.com.centroEfectivo.revision.values.Novedad;
import co.com.centroEfectivo.revision.values.ReporteId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Reporte extends Entity<ReporteId> {
    private Novedad novedad;
    private final Fecha fecha;

    public Reporte(ReporteId reporteId, Fecha fecha, Novedad novedad) {
        super(reporteId);
        this.fecha = fecha;
        this.novedad = novedad;
    }

    public void actualizarNovedad(Novedad novedad) {
        this.novedad = Objects.requireNonNull(novedad);
    }

    public Novedad novedad() {
        return novedad;
    }

    public Fecha fecha() {
        return fecha;
    }
}
