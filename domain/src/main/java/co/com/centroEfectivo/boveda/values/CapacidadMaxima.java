package co.com.centroEfectivo.boveda.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CapacidadMaxima implements ValueObject<Integer> {

    private final Integer value;
    public CapacidadMaxima(Integer value){
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
        CapacidadMaxima capacidadMaxima = (CapacidadMaxima) o;
        return Objects.equals(value, capacidadMaxima.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
