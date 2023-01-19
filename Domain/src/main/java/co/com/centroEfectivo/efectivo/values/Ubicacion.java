package co.com.centroEfectivo.efectivo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ubicacion implements ValueObject<Ubicacion.UbicacionEnum> {

    private final UbicacionEnum value;

    public Ubicacion(UbicacionEnum value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public UbicacionEnum value() {
        return value;
    }


    enum UbicacionEnum{
        TULA,
        BOVEDA
    }
}
