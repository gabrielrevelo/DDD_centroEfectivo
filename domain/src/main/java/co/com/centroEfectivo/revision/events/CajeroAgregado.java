package co.com.centroEfectivo.revision.events;

import co.com.centroEfectivo.revision.values.CajeroId;
import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.centroEfectivo.revision.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class CajeroAgregado extends DomainEvent {
    private final CajeroId cajeroId;
    private final Nombre nombre;

    public CajeroAgregado(CajeroId cajeroId, Nombre nombre) {
        super("centroEfectivo.revision.cajeroagregado");
        this.cajeroId = cajeroId;
        this.nombre = nombre;
    }

    public CajeroId getCajeroId() {
        return cajeroId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
