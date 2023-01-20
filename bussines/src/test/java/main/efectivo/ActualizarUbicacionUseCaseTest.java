package main.efectivo;

import co.com.centroEfectivo.efectivo.commands.ActualizarUbicacion;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
import co.com.centroEfectivo.efectivo.events.UbicacionActualizada;
import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarUbicacionUseCaseTest {
    @InjectMocks
    private ActualizarUbicacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarCostoEnvioHappyPass(){
        //Arrange
        EfectivoId efectivoId = EfectivoId.of("xxx");
        Ubicacion ubicacion = new Ubicacion(Ubicacion.UbicacionEnum.BOVEDA);
        var command = new ActualizarUbicacion(efectivoId, ubicacion);

        when(repository.getEventsBy("xxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEfectivoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (UbicacionActualizada)events.get(0);
        Assertions.assertEquals(Ubicacion.UbicacionEnum.BOVEDA, event.getUbicacion().value());
    }

    private List<DomainEvent> history(){
        Cantidad cantidad = new Cantidad(4300);
        Ubicacion ubicacion = new Ubicacion(Ubicacion.UbicacionEnum.TULA);
        var event = new EfectivoCreado(
               cantidad, ubicacion
        );
        event.setAggregateRootId("xxxxxxxxx");

        return List.of(event);
    }

}