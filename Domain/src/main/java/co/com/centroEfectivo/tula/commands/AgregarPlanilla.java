package co.com.centroEfectivo.tula.commands;

import co.com.centroEfectivo.tula.values.Direccion;
import co.com.centroEfectivo.tula.values.PlanillaId;
import co.com.sofka.domain.generic.Command;

public class AgregarPlanilla extends Command {
    private final PlanillaId planillaId;
    private final Direccion direccion;

    public AgregarPlanilla(PlanillaId planillaId, Direccion direccion) {
        this.planillaId = planillaId;
        this.direccion = direccion;
    }

    public PlanillaId getPlanillaId() {
        return planillaId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
