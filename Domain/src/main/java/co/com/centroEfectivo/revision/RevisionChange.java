package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.entities.Cajero;
import co.com.centroEfectivo.revision.entities.Reporte;
import co.com.centroEfectivo.revision.events.CajeroAgregado;
import co.com.centroEfectivo.revision.events.ReporteAgregado;
import co.com.centroEfectivo.revision.events.RevisionCreada;
import co.com.centroEfectivo.revision.events.TulaAsociada;
import co.com.sofka.domain.generic.EventChange;

public class RevisionChange extends EventChange {
    public RevisionChange(Revision revision) {

        apply((RevisionCreada event) -> {
            revision.cubiculo = event.getCubiculo();
        });

        apply((TulaAsociada event) -> {
            revision.tulaId = event.getTulaId();
        });

        apply((CajeroAgregado event) -> {
            revision.cajero = new Cajero(event.getCajeroId(), event.getNombre());
        });

        apply((ReporteAgregado event) -> {
            revision.reporte = new Reporte(event.getReporteId(), event.getFecha(), event.getNovedad());
        });

    }
}
