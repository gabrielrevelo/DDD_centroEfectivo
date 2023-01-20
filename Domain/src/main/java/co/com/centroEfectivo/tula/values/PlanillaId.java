package co.com.centroEfectivo.tula.values;

import co.com.centroEfectivo.revision.values.ReporteId;
import co.com.sofka.domain.generic.Identity;

public class PlanillaId extends Identity {
    public PlanillaId(){

    }

    private PlanillaId(String id) {
        super(id);
    }

    public static PlanillaId of(String id) {
        return new PlanillaId(id);
    }
}
