package co.com.centroEfectivo.tula.commands;

import co.com.centroEfectivo.tula.values.Direccion;
import co.com.centroEfectivo.tula.values.Fecha;
import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.domain.generic.Command;

public class AgregarPlanilla extends Command {
    private final TulaId tulaId;

    private final Fecha fecha;
    private final Direccion direccion;

    public AgregarPlanilla(TulaId tulaId, Fecha fecha, Direccion direccion) {
        this.tulaId = tulaId;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public TulaId getTulaId() {
        return tulaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
