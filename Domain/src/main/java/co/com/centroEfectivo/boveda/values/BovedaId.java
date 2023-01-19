package co.com.centroEfectivo.boveda.values;

import co.com.sofka.domain.generic.Identity;

public class  BovedaId extends Identity {

    private BovedaId(String id) {
        super(id);
    }

    public BovedaId () {};

    public static BovedaId of(String id) {
        return new BovedaId(id);
    }
}
