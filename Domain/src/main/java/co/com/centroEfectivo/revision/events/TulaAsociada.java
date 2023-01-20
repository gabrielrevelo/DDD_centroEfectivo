package co.com.centroEfectivo.revision.events;

import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.domain.generic.DomainEvent;

public class TulaAsociada extends DomainEvent {
    private final TulaId tulaId;

    public TulaAsociada(TulaId tulaId) {
        super("centroEfectivo.tula.efectivoasociado");
        this.tulaId = tulaId;
    }

    public TulaId getTulaId() {
        return tulaId;
    }
}
