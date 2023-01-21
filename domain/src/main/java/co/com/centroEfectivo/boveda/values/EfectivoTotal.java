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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EfectivoTotal efectivoTotal = (EfectivoTotal) o;
        return Objects.equals(value, efectivoTotal.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

