package co.com.centroEfectivo.boveda.commands;


import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.boveda.values.EfectivoTotal;
import co.com.sofka.domain.generic.Command;

public class CrearBoveda extends Command {

    private final BovedaId bovedaId;
    private final EfectivoTotal efectivoTotal;

    public CrearBoveda(BovedaId bovedaId, EfectivoTotal efectivoTotal) {
        this.bovedaId = bovedaId;
        this.efectivoTotal = efectivoTotal;

    }

    public BovedaId getBovedaId() {
        return bovedaId;
    }

    public EfectivoTotal getEfectivoTotal() {
        return efectivoTotal;
    }
}
