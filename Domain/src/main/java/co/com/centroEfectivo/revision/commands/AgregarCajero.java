package co.com.centroEfectivo.revision.commands;

import co.com.centroEfectivo.revision.values.CajeroId;
import co.com.centroEfectivo.revision.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class AgregarCajero extends Command {
    private final CajeroId cajeroId;
    private final Nombre nombre;

    public AgregarCajero(CajeroId cajeroId, Nombre nombre) {
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
