package co.com.centroEfectivo.revision.values;

import co.com.sofka.domain.generic.Identity;

public class CajeroId extends Identity {

    public CajeroId(){

    }

    private CajeroId(String id) {
        super(id);
    }

    public static CajeroId of(String id) {
        return new PersonaId(id);
    }

}
