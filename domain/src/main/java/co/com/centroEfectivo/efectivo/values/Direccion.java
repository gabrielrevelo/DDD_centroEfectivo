package co.com.centroEfectivo.efectivo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {

    private final String value;
    public Direccion(String value){this.value = Objects.requireNonNull(value);}

    @Override
    public String value() {return value;}
}
