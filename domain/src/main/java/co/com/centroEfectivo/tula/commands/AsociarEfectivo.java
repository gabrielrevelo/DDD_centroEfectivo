package co.com.centroEfectivo.tula.commands;

import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.domain.generic.Command;

public class AsociarEfectivo extends Command {
    private final TulaId tulaId;
    private final EfectivoId efectivoId;

    public AsociarEfectivo(TulaId tulaId, EfectivoId efectivoId) {
        this.tulaId = tulaId;
        this.efectivoId = efectivoId;
    }

    public TulaId getTulaId() {
        return tulaId;
    }

    public EfectivoId getEfectivoId() {
        return efectivoId;
    }
}
