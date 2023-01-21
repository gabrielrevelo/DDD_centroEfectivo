package co.com.centroEfectivo.efectivo.entities;

import co.com.centroEfectivo.efectivo.values.ClienteId;
import co.com.centroEfectivo.efectivo.values.Contacto;
import co.com.centroEfectivo.efectivo.values.Direccion;
import co.com.centroEfectivo.efectivo.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Cliente extends Entity<ClienteId> {

    private Nombre nombre;
    private Contacto contacto;
    private Direccion direccion;


    public Cliente(ClienteId clienteId,Nombre nombre, Contacto contacto, Direccion direccion) {
        super(clienteId);
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
