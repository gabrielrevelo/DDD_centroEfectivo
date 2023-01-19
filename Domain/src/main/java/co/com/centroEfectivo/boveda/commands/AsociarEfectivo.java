package co.com.centroEfectivo.boveda.commands;

import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.sofka.domain.generic.Command;

public class AsociarEfectivo extends Command {

    private final BovedaId bovedaId;
    private final EfectivoId efectivoId;

    public AsociarEfectivo(BovedaId bovedaId, EfectivoId efectivoId) {
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
