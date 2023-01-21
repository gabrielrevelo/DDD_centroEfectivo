package co.com.centroEfectivo.revision.values;

import co.com.sofka.domain.generic.Identity;

public class RevisionId extends Identity {

    public RevisionId(){

    }

    private RevisionId(String id) {
        super(id);
    }

    public static RevisionId of(String id) {
        return new RevisionId(id);
    }

}
