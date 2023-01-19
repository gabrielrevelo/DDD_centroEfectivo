package co.com.centroEfectivo.revision.events;

import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.sofka.domain.generic.DomainEvent;

public class RevisionCreada extends DomainEvent {
    private final Cubiculo cubiculo;

    public RevisionCreada(Cubiculo cubiculo) {
        super("centroEfectivo.revision.revisioncreada");
        this.cubiculo = cubiculo;
    }

    public Cubiculo getCubiculo() {
        return cubiculo;
    }
}
