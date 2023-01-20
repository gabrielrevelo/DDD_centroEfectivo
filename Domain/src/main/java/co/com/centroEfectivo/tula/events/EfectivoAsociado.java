package co.com.centroEfectivo.tula.events;


import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.domain.generic.DomainEvent;

public class EfectivoAsociado extends DomainEvent {
    private final EfectivoId efectivoId;

    public EfectivoAsociado(EfectivoId efectivoId) {
        super("centroEfectivo.tula.efectivoasociado");
        this.efectivoId = efectivoId;
    }

    public EfectivoId getEfectivoId() {
        return efectivoId;
    }
}
