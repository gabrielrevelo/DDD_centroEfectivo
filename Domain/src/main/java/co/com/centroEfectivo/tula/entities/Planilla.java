package co.com.centroEfectivo.tula.entities;

import co.com.centroEfectivo.tula.values.Direccion;
import co.com.centroEfectivo.tula.values.Fecha;
import co.com.centroEfectivo.tula.values.PlanillaId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Planilla extends Entity<PlanillaId> {
    private final Fecha fecha;
    private Direccion direccion;

    public Planilla (PlanillaId planillaId, Fecha fecha, Direccion direccion) {
        super(planillaId);
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public void actualizarDireccion(Direccion direccion) {
        this.direccion = Objects.requireNonNull(direccion);
    }

    public Fecha fecha() {
        return fecha;
    }

    public Direccion direccion() {
        return direccion;
    }
}
