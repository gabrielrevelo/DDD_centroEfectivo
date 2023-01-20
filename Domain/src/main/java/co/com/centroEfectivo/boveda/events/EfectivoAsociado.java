package co.com.centroEfectivo.boveda.events;

import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EfectivoAsociado extends DomainEvent {
    private final EfectivoId efectivoId;
    private final BovedaId bovedaId;

    public EfectivoAsociado(BovedaId bovedaId,EfectivoId efectivoId) {
        super("co.com.centroEfectivo.boveda.events.EfectivoAsociado");
        this.efectivoId = efectivoId;
        this.bovedaId = bovedaId;
    }

    public BovedaId getBovedaId() {return bovedaId;}

    public EfectivoId getEfectivoId(){
        return efectivoId;
    }
}
