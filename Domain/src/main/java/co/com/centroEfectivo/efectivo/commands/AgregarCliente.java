package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.values.ClienteId;
import co.com.centroEfectivo.efectivo.values.Contacto;
import co.com.centroEfectivo.efectivo.values.Direccion;
import co.com.centroEfectivo.efectivo.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class AgregarCliente extends Command {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Contacto contacto;
    private final Direccion direccion;


    public AgregarCliente(ClienteId clienteId, Nombre nombre, Contacto contacto, Direccion direccion) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {return direccion;
    }
    public Contacto getContacto() {return contacto;
    }

    public Nombre getNombre() {return nombre;
    }

    public ClienteId getClienteId() {return clienteId;
    }
}
