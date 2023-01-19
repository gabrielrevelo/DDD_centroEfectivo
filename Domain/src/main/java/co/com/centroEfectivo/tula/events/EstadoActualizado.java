package co.com.centroEfectivo.tula.events;

import co.com.centroEfectivo.tula.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoActualizado extends DomainEvent {
    private final Estado estado;
    public EstadoActualizado(Estado estado) {
        super("centroEfectivo.tula.estadoactualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
