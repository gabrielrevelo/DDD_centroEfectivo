package co.com.centroEfectivo.revision.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Novedad implements ValueObject<String> {
    private final String value;

    public Novedad (String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(this.value.length() <= 4) {
            throw new IllegalArgumentException("Debe tener al menos 5 caracteres");
        }
        if(this.value.length() >= 50) {
            throw new IllegalArgumentException("Debe tener menos de 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novedad novedad = (Novedad) o;
        return Objects.equals(value, novedad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
