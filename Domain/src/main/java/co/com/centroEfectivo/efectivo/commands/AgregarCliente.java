package co.com.centroEfectivo.efectivo.commands;

import co.com.centroEfectivo.efectivo.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarCliente extends Command {

    private final ClienteId clienteId;

    private final EfectivoId efectivoId;
    private final Nombre nombre;
    private final Contacto contacto;
    private final Direccion direccion;


    public AgregarCliente(EfectivoId efectivoId, ClienteId clienteId, Nombre nombre, Contacto contacto, Direccion direccion) {
        this.clienteId = clienteId;
        this.efectivoId = efectivoId;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public EfectivoId getEfectivoId() {return efectivoId;}

    public Direccion getDireccion() {return direccion;
    }
    public Contacto getContacto() {return contacto;
    }

    public Nombre getNombre() {return nombre;
    }

    public ClienteId getClienteId() {return clienteId;
    }
}
