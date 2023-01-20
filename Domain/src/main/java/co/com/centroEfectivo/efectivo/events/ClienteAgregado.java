package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteAgregado extends DomainEvent {

    private final ClienteId clienteId;

    private final EfectivoId efectivoId;
    private final Nombre nombre;
    private final Contacto contacto;
    private final Direccion direccion;

    public ClienteAgregado(EfectivoId efectivoId,ClienteId clienteId, Nombre nombre, Contacto contacto, Direccion direccion) {

        super("co.com.centroEfectivo.efectivo.events.ClienteAgregado");
        this.efectivoId = efectivoId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public EfectivoId getEfectivoId() {return efectivoId;}

    public Direccion getDireccion() {return direccion;}

    public Nombre getNombre() {return nombre;}

    public Contacto getContacto() {return contacto;}

    public ClienteId getClienteId() {return clienteId;}

}
