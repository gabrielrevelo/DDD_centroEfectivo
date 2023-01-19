package co.com.centroEfectivo.efectivo.events;

import co.com.centroEfectivo.efectivo.values.ClienteId;
import co.com.centroEfectivo.efectivo.values.Contacto;
import co.com.centroEfectivo.efectivo.values.Direccion;
import co.com.centroEfectivo.efectivo.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteAgregado extends DomainEvent {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Contacto contacto;
    private final Direccion direccion;

    public ClienteAgregado(ClienteId clienteId, Nombre nombre, Contacto contacto, Direccion direccion) {

        super("co.com.centroEfectivo.efectivo.events.ClienteAgregado");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {return direccion;}

    public Nombre getNombre() {return nombre;}

    public Contacto getContacto() {return contacto;}

    public ClienteId getClienteId() {return clienteId;}

}
