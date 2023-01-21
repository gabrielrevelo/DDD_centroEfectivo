package co.com.centroEfectivo.tula.events;

import co.com.centroEfectivo.tula.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class TulaCreada extends DomainEvent {
    private final Estado estado;
    public TulaCreada(Estado estado) {
        super("centroEfectivo.tula.tulacreada");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
