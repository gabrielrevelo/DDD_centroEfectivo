package co.com.centroEfectivo.tula.events;

import co.com.centroEfectivo.tula.values.Direccion;
import co.com.centroEfectivo.tula.values.Fecha;
import co.com.centroEfectivo.tula.values.PlanillaId;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanillaAgregada extends DomainEvent {
    private final PlanillaId planillaId;
    private final Fecha fecha;
    private final Direccion direccion;
    public PlanillaAgregada(PlanillaId planillaId, Fecha fecha, Direccion direccion) {
        super("centroEfectivo.tula.planillaagregada");
        this.planillaId = planillaId;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public PlanillaId getPlanillaId() {
        return planillaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
