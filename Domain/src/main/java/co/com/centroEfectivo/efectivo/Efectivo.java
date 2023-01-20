package co.com.centroEfectivo.efectivo;

import co.com.centroEfectivo.efectivo.entities.Cliente;
import co.com.centroEfectivo.efectivo.events.CantidadActualizada;
import co.com.centroEfectivo.efectivo.events.ClienteAgregado;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
import co.com.centroEfectivo.efectivo.events.UbicacionActualizada;
import co.com.centroEfectivo.efectivo.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;

public class Efectivo extends AggregateEvent<EfectivoId> {

    protected Cliente cliente;
    protected Ubicacion ubicacion;
    protected Cantidad cantidad;



    public Efectivo(EfectivoId efectivoId,Cliente cliente,Cantidad cantidad,Ubicacion ubicacion) {
        super(efectivoId);
        appendChange(new EfectivoCreado(cliente,cantidad,ubicacion)).apply();
    }

    private Efectivo(EfectivoId efectivoId) {
        super(efectivoId);
        subscribe(new EfectivoChange(this));
    }

    public void agregarCliente(ClienteId clienteId, Nombre nombre, Contacto contacto, Direccion direccion){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(contacto);
        Objects.requireNonNull(direccion);
        appendChange(new ClienteAgregado(clienteId,nombre,contacto,direccion)).apply();
    }

    public void actualizarUbicacion(Ubicacion ubicacion){
        Objects.requireNonNull(ubicacion);
        appendChange(new UbicacionActualizada(ubicacion)).apply();
    }

    public void actualizarCantidad(Cantidad cantidad){
        Objects.requireNonNull(cantidad);
        appendChange(new CantidadActualizada(cantidad)).apply();
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
