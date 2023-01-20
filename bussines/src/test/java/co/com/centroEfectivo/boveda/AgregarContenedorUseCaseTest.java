package co.com.centroEfectivo.boveda;


import co.com.centroEfectivo.boveda.commands.AgregarContendor;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.events.ContenedorAgregado;
import co.com.centroEfectivo.boveda.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.centroEfectivo.boveda.AgregarContenedorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarContenedorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Contenedor a Boveda")
    public void agregarContenedorHappyPass(){
        //arrage
        var command = new AgregarContendor(
                BovedaId.of("1"),
                ContenedorId.of("2"),new CapacidadMaxima(50), new CapacidadActual(10));


        var agregarContenedorUseCase = new AgregarContenedorUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        agregarContenedorUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarContenedorUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (ContenedorAgregado)response.getDomainEvents().get(0);
        Assertions.assertEquals(BovedaId.of("1"),event.getBovedaId());
        Assertions.assertEquals(ContenedorId.of("2"),event.getContenedorId());
        Assertions.assertEquals(50,event.getCapacidadMaxima().value());
        Assertions.assertEquals(10,event.getCapacidadActual().value());
        Assertions.assertEquals("co.com.centroEfectivo.boveda.events.contenedorAgregado",event.type);
    }

    private List<DomainEvent> events() {
        return List.of(new BovedaCreada(
                new EfectivoTotal(5)
        ));
    }
}