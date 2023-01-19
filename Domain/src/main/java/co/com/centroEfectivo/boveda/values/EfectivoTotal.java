package co.com.centroEfectivo.boveda.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EfectivoTotal implements ValueObject<Integer> {

    private final Integer value;
    public EfectivoTotal(Integer value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}

