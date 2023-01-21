package co.com.centroEfectivo.revision.commands;

import co.com.centroEfectivo.revision.values.RevisionId;
import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.domain.generic.Command;

public class AsociarTula extends Command {
    private final RevisionId revisionId;
    private final TulaId tulaId;

    public AsociarTula(RevisionId revisionId, TulaId tulaId) {
        this.revisionId = revisionId;
        this.tulaId = tulaId;
    }

    public RevisionId getRevisionId() {
        return revisionId;
    }

    public TulaId getTulaId() {
        return tulaId;
    }
}
