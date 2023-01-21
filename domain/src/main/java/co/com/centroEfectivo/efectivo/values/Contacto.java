package co.com.centroEfectivo.efectivo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Contacto implements ValueObject<String> {

    private final String value;

    public Contacto(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

}
