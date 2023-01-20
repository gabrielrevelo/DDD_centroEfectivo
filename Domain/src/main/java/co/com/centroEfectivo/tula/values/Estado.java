package co.com.centroEfectivo.tula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<EstadoEnum> {
    private final EstadoEnum value;

    public Estado (EstadoEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    public EstadoEnum value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return value == estado.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

enum EstadoEnum {
    INGRESADA,
    EN_PROCESO,
    PROCESADA
}
