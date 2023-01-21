package co.com.centroEfectivo.boveda.commands;

import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.domain.generic.Command;

public class AsociarEfectivoABoveda extends Command {

    private final BovedaId bovedaId;
    private final EfectivoId efectivoId;

    public AsociarEfectivoABoveda(BovedaId bovedaId, EfectivoId efectivoId) {
        this.bovedaId = bovedaId;
        this.efectivoId = efectivoId;
    }

    public BovedaId getBovedaId() {
        return bovedaId;
    }

    public EfectivoId getEfectivoId() {
        return efectivoId;
    }
}
