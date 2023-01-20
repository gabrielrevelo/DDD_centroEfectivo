package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.entities.Cliente;
import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.ClienteId;
import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public class EfectivoCreado extends DomainEvent {

    private final Cantidad cantidad;
    private final Ubicacion ubicacion;
    public EfectivoCreado( Cantidad cantidad, Ubicacion ubicacion) {

        super("co.com.centroEfectivo.efectivo.events.EfectivoCreado");
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {return ubicacion;}

    public Cantidad getCantidad() {return cantidad;}
}
