package co.com.centroEfectivo.boveda.events;

import co.com.centroEfectivo.boveda.values.EfectivoTotal;
import co.com.sofka.domain.generic.DomainEvent;

public class BovedaCreada extends DomainEvent {

    private final EfectivoTotal efectivototal;

    public BovedaCreada(EfectivoTotal efectivoTotal) {
        super("co.com.centroEfectivo.boveda.events.BovedaCreada");
        this.efectivototal = efectivoTotal;

    }

    public EfectivoTotal getEfectivototal() {
        return efectivototal;
    }

}
