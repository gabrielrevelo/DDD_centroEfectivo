package co.com.centroEfectivo.tula.commands;

import co.com.centroEfectivo.tula.values.Estado;
import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.domain.generic.Command;

public class CrearTula extends Command {

    private final TulaId tulaId;
    private final Estado estado;

    public CrearTula(TulaId tulaId, Estado estado) {
        this.tulaId = tulaId;
        this.estado = estado;
    }

    public TulaId getTulaId() {
        return tulaId;
    }

    public Estado getEstado() {
        return estado;
    }
}
