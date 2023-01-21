package co.com.centroEfectivo.revision.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cubiculo implements ValueObject<Integer> {
    private final Integer value;

    public Cubiculo (Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cubiculo cubiculo = (Cubiculo) o;
        return Objects.equals(value, cubiculo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
