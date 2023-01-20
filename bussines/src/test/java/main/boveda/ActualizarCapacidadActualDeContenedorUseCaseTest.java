package main.boveda;


import co.com.centroEfectivo.boveda.commands.ActualizarCapacidadActualDeContenedor;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.events.CapacidadActualDeContenedorActualizada;
import co.com.centroEfectivo.boveda.events.ContenedorAgregado;
import co.com.centroEfectivo.boveda.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import main.boveda.ActualizarCapacidadActualDeContenedorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCapacidadActualDeContenedorUseCaseTest {

    @InjectMocks
    private ActualizarCapacidadActualDeContenedorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarCapacidadActualDeContenedorHappyPass(){
        //arrange
        BovedaId bovedaId = BovedaId.of("11");
        ContenedorId contenedorId = ContenedorId.of("qqq");
        CapacidadActual capacidadActual = new CapacidadActual(20);
        var command = new ActualizarCapacidadActualDeContenedor(bovedaId,contenedorId,capacidadActual);

        when(repository.getEventsBy("11")).thenReturn(history());

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CapacidadActualDeContenedorActualizada)events.get(0);
        Assertions.assertEquals(ContenedorId.of("qqq"),event.getContenedorId());
        Assertions.assertEquals(20,event.getCapacidadActual().value());

    }

    private List<DomainEvent> history() {

        EfectivoTotal efectivoTotal = new EfectivoTotal(30);
        var event = new BovedaCreada(efectivoTotal);

        event.setAggregateRootId("1");
        BovedaId bovedaId = BovedaId.of("xxxx");
        ContenedorId contenedorId = ContenedorId.of("qqq");
        CapacidadMaxima capacidadMaxima = new CapacidadMaxima(80);
        CapacidadActual capacidadActual = new CapacidadActual(50);
        var event2 = new ContenedorAgregado(bovedaId,contenedorId,capacidadMaxima,capacidadActual);

        return List.of(event,event2);
    }

}