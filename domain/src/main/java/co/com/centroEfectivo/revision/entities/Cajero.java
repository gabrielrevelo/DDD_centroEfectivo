package co.com.centroEfectivo.revision.entities;

import co.com.centroEfectivo.revision.values.CajeroId;
import co.com.centroEfectivo.revision.values.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cajero extends Entity<CajeroId> {
    private Nombre nombre;

    public Cajero(CajeroId cajeroId, Nombre nombre) {
        super(cajeroId);
        this.nombre = nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nombre nombre() {
        return nombre;
    }

}
