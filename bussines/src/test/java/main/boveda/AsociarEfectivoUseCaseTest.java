package main.boveda;


import co.com.centroEfectivo.boveda.commands.AsociarEfectivoABoveda;
import co.com.centroEfectivo.boveda.events.BovedaCreada;
import co.com.centroEfectivo.boveda.events.EfectivoAsociado;
import co.com.centroEfectivo.boveda.values.BovedaId;
import co.com.centroEfectivo.boveda.values.EfectivoTotal;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import main.boveda.AsociarEfectivoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsociarEfectivoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Asociar Efectivo a Boveda")
    public void asociarEfectivoHappyPass(){
        //arrage
        var command = new AsociarEfectivoABoveda(BovedaId.of("1"),
                EfectivoId.of("20")
        );
        var asociarEfectivoUseCase = new AsociarEfectivoUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        asociarEfectivoUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asociarEfectivoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (EfectivoAsociado)response.getDomainEvents().get(0);
        Assertions.assertEquals(BovedaId.of("1"),event.getBovedaId());
        Assertions.assertEquals(EfectivoId.of("20"),event.getEfectivoId());
    }

    private List<DomainEvent> events() {
        return List.of(new BovedaCreada(
                new EfectivoTotal(50)
        ));
    }
}