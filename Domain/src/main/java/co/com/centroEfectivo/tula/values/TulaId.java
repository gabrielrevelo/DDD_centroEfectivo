package co.com.centroEfectivo.tula.values;

import co.com.centroEfectivo.revision.values.ReporteId;
import co.com.sofka.domain.generic.Identity;

public class TulaId extends Identity {
    public TulaId(){

    }

    private TulaId(String id) {
        super(id);
    }

    public static TulaId of(String id) {
        return new TulaId(id);
    }
}
