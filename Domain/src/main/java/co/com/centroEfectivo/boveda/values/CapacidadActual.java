package co.com.centroEfectivo.boveda.values;

import co.com.centroEfectivo.revision.values.Nombre;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CapacidadActual implements ValueObject<Integer> {

    private final Integer value;
    public CapacidadActual(Integer value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapacidadActual capacidadActual = (CapacidadActual) o;
        return Objects.equals(value, capacidadActual.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
