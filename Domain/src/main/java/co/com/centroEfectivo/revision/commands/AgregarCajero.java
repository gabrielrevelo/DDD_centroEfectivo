package co.com.centroEfectivo.revision.commands;

import co.com.centroEfectivo.revision.values.Nombre;
import co.com.centroEfectivo.revision.values.RevisionId;
import co.com.sofka.domain.generic.Command;

public class AgregarCajero extends Command {
    private final RevisionId revisionId;
    private final Nombre nombre;

    public AgregarCajero(RevisionId revisionId, Nombre nombre) {
        this.revisionId = revisionId;
        this.nombre = nombre;
    }

    public RevisionId getRevisionId() {
        return revisionId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
