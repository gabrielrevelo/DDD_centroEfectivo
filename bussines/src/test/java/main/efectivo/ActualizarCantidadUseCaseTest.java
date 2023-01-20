package main.efectivo;


import co.com.centroEfectivo.efectivo.commands.ActualizarCantidad;
import co.com.centroEfectivo.efectivo.events.CantidadActualizada;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
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
class ActualizarCantidadUseCaseTest {

    @InjectMocks
    private ActualizarCantidadUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarCantidadHappyPass(){
        //arrage
        var command = new ActualizarCantidad(
                EfectivoId.of("1"),
                new Cantidad(2300)
        );


        when(repository.getEventsBy("1")).thenReturn(events());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEfectivoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (CantidadActualizada)events.get(0);
        Assertions.assertEquals(2300,event.getCantidad().value());
    }

    private List<DomainEvent> events() {
        return List.of(new EfectivoCreado(
                    new Cantidad(4600),
                new Ubicacion(Ubicacion.UbicacionEnum.BOVEDA)
        ));
    }
}