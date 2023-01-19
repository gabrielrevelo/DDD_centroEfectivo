package co.com.centroEfectivo.boveda.values;

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
}
