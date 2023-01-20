package main.boveda;

import co.com.centroEfectivo.boveda.commands.CrearBoveda;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.boveda.values.EfectivoTotal;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CrearBovedaUseCaseTest {

    private CrearBovedaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearBovedaUseCase();
    }

    @Test
    public void crearBovedaHappyPass(){
        //arrange
        BovedaId bovedaId = BovedaId.of("xxx");
        EfectivoTotal efectivoTotal = new EfectivoTotal(10);

        var command = new CrearBoveda(bovedaId,efectivoTotal);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var bovedaCreada = (BovedaCreada)events.get(0);
        Assertions.assertEquals("xxx", bovedaCreada.aggregateRootId());
        Assertions.assertEquals(10, bovedaCreada.getEfectivototal().value());
    }
}