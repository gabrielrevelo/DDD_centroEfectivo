package co.com.centroEfectivo.revision.commands;

import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.centroEfectivo.revision.values.RevisionId;
import co.com.sofka.domain.generic.Command;

public class CrearRevision extends Command {
    private final RevisionId revisionId;
    private final Cubiculo cubiculo;

    public CrearRevision(RevisionId revisionId, Cubiculo cubiculo) {
        this.revisionId = revisionId;
        this.cubiculo = cubiculo;
    }

    public RevisionId getRevisionId() {
        return revisionId;
    }

    public Cubiculo getCubiculo() {
        return cubiculo;
    }
}
