package co.com.centroEfectivo.revision.values;

import co.com.sofka.domain.generic.Identity;

public class ReporteId extends Identity {

    public ReporteId(){

    }

    private ReporteId(String id) {
        super(id);
    }

    public static ReporteId of(String id) {
        return new ReporteId(id);
    }

}
