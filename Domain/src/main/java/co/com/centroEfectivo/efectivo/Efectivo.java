package co.com.centroEfectivo.efectivo;

import co.com.centroEfectivo.boveda.Boveda;
import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.efectivo.entities.Cliente;
import co.com.centroEfectivo.efectivo.events.CantidadActualizada;
import co.com.centroEfectivo.efectivo.events.ClienteAgregado;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
import co.com.centroEfectivo.efectivo.events.UbicacionActualizada;
import co.com.centroEfectivo.efectivo.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Efectivo extends AggregateEvent<EfectivoId> {

    protected Cliente cliente;
    protected Ubicacion ubicacion;
    protected Cantidad cantidad;



    public Efectivo(EfectivoId efectivoId,Cantidad cantidad,Ubicacion ubicacion) {
        super(efectivoId);
        appendChange(new EfectivoCreado(cantidad,ubicacion)).apply();
    }

    private Efectivo(EfectivoId efectivoId) {
        super(efectivoId);
        subscribe(new EfectivoChange(this));
    }

    public static Efectivo from(EfectivoId efectivoId, List<DomainEvent> events){
        var efectivo = new Efectivo(efectivoId);
        events.forEach(efectivo::applyEvent);
        return efectivo;
    }

    public void agregarCliente(EfectivoId efectivoId,ClienteId clienteId, Nombre nombre, Contacto contacto, Direccion direccion){
        Objects.requireNonNull(efectivoId);
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(contacto);
        Objects.requireNonNull(direccion);
        appendChange(new ClienteAgregado(efectivoId,clienteId,nombre,contacto,direccion)).apply();
    }

    public void actualizarUbicacion(Ubicacion ubicacion){
        Objects.requireNonNull(ubicacion);
        appendChange(new UbicacionActualizada(ubicacion)).apply();
    }

    public void actualizarCantidad(EfectivoId efectivoId,Cantidad cantidad){
        Objects.requireNonNull(cantidad);
        appendChange(new CantidadActualizada(efectivoId,cantidad)).apply();
    }


    public Cantidad getCantidad() {
        return cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
