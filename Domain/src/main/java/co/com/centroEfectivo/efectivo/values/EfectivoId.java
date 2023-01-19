package co.com.centroEfectivo.efectivo.values;

import co.com.sofka.domain.generic.Identity;

public class EfectivoId extends Identity {

    private EfectivoId(String id){super(id);}

    public EfectivoId(){};

    public static EfectivoId of(String id){return new EfectivoId(id);}
}
