package co.com.centroEfectivo.revision.commands;

import co.com.centroEfectivo.revision.values.Fecha;
import co.com.centroEfectivo.revision.values.Novedad;
import co.com.centroEfectivo.revision.values.ReporteId;
import co.com.centroEfectivo.revision.values.RevisionId;
import co.com.sofka.domain.generic.Command;

public class AgregarReporte extends Command {
    private final RevisionId revisionId;
    private final Fecha fecha;
    private final Novedad novedad;

    public AgregarReporte(RevisionId revisionId, Fecha fecha, Novedad novedad) {
        this.revisionId = revisionId;
        this.fecha = fecha;
        this.novedad = novedad;
    }

    public RevisionId getRevisionId() {
        return revisionId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Novedad getNovedad() {
        return novedad;
    }
}
