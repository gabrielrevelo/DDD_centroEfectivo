package co.com.centroEfectivo.boveda.events;

import co.com.sofka.domain.generic.DomainEvent;

public class EfectivoAsociado extends DomainEvent {
    private final EfectivoId efectivoId;

    public EfectivoAsociado(EfectivoId efectivoId) {
        super("co.com.centroEfectivo.boveda.events.EfectivoAsociado");
        this.efectivoId = efectivoId;
    }

    public EfectivoId getEfectivoId(){
        retrun efectivoId;
    }
}
