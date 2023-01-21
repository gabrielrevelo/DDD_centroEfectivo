package co.com.centroEfectivo.boveda.values;

import co.com.sofka.domain.generic.Identity;

public class ContenedorId extends Identity {

    private ContenedorId(String id) {
        super(id);
    }

    public ContenedorId () {};

    public static ContenedorId of(String id) {
        return new ContenedorId(id);
    }
}


