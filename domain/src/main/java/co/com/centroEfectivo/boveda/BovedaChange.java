package co.com.centroEfectivo.boveda;

import co.com.centroEfectivo.boveda.entities.Contenedor;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.events.CapacidadActualDeContenedorActualizada;
import co.com.centroEfectivo.boveda.events.ContenedorAgregado;
import co.com.centroEfectivo.boveda.events.EfectivoAsociado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class BovedaChange extends EventChange {
    public BovedaChange(Boveda boveda) {

        apply((BovedaCreada event) -> {
            boveda.efectivoTotal = event.getEfectivototal();
            boveda.contenedores = new HashSet<>();
        });

        apply((EfectivoAsociado event) -> {
           boveda.efectivoId = event.getEfectivoId();
        });


        apply((CapacidadActualDeContenedorActualizada event) -> {
          var contenedor =  boveda.getContenedorPorId(event.getContenedorId())
                  .orElseThrow(()-> new IllegalArgumentException("No se encuentra la función de la persona"));
          contenedor.actualizarCapacidadActual(event.getCapacidadActual());
        });

        apply((ContenedorAgregado event)-> {
            boveda.contenedores.add(new Contenedor(
                        event.getContenedorId(),
                    event.getCapacidadMaxima(),
                    event.getCapacidadActual()
                    ));
        });

    }
}
