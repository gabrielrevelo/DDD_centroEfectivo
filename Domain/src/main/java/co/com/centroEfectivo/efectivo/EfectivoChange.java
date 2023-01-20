package co.com.centroEfectivo.efectivo;


import co.com.centroEfectivo.efectivo.entities.Cliente;
import co.com.centroEfectivo.efectivo.events.CantidadActualizada;
import co.com.centroEfectivo.efectivo.events.ClienteAgregado;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
import co.com.centroEfectivo.efectivo.events.UbicacionActualizada;
import co.com.sofka.domain.generic.EventChange;

public class EfectivoChange extends EventChange {
    public EfectivoChange(Efectivo efectivo) {

        apply((EfectivoCreado event) -> {
            efectivo.cantidad = event.getCantidad();
            efectivo.cliente = event.getCliente();
            efectivo.ubicacion = event.getUbicacion();
        });

        apply((UbicacionActualizada event) -> {

            efectivo.ubicacion = event.getUbicacion();
        });

        apply((CantidadActualizada event) -> {

            efectivo.cantidad = event.getCantidad();
        });

        apply((ClienteAgregado event) -> {
            efectivo.cliente = new Cliente(
                    event.getClienteId(),
                    event.getNombre(),
                    event.getContacto(),
                    event.getDireccion()
            );
        });
    }
}
