package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.revision.entities.Cajero;
import co.com.centroEfectivo.tula.entities.Planilla;
import co.com.centroEfectivo.tula.events.EfectivoAsociado;
import co.com.centroEfectivo.tula.events.EstadoActualizado;
import co.com.centroEfectivo.tula.events.PlanillaAgregada;
import co.com.centroEfectivo.tula.events.TulaCreada;
import co.com.sofka.domain.generic.EventChange;

public class TulaChange extends EventChange {
    public TulaChange(Tula tula) {

        apply((TulaCreada event) -> {
            tula.estado = event.getEstado();
        });

        apply((EfectivoAsociado event) -> {
            tula.efectivoId = event.getEfectivoId();
        });

        apply((PlanillaAgregada event) -> {
            tula.planilla = new Planilla(event.getPlanillaId(), event.getFecha(), event.getDireccion());
        });

        apply((EstadoActualizado event) -> {
            tula.estado = event.getEstado();
        });
    }
}
