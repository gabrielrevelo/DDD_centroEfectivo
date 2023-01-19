package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.entities.Cliente;
import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.ClienteId;
import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public class EfectivoCreado extends DomainEvent {

    private final Cliente cliente;
    private final Cantidad cantidad;
    private final Ubicacion ubicacion;
    public EfectivoCreado(Cliente cliente, Cantidad cantidad, Ubicacion ubicacion) {

        super("co.com.centroEfectivo.efectivo.events.EfectivoCreado");
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {return ubicacion;}

    public Cliente getCliente() {return cliente;}

    public Cantidad getCantidad() {return cantidad;}
}
