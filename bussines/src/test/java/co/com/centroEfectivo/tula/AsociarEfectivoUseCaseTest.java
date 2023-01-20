package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.tula.commands.AsociarEfectivo;
import co.com.centroEfectivo.tula.events.EfectivoAsociado;
import co.com.centroEfectivo.tula.events.TulaCreada;
import co.com.centroEfectivo.tula.values.Estado;
import co.com.centroEfectivo.tula.values.EstadoEnum;
import co.com.centroEfectivo.tula.values.TulaId;
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
public class AsociarEfectivoUseCaseTest {
    @InjectMocks
    private AsociarEfectivoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asociarEfectivo() {
        var command = new AsociarEfectivo(
                TulaId.of("Tula-001"),
                EfectivoId.of("Efectivo-001")
        );

        when(repository.getEventsBy("Tula-001")).thenReturn(history());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTulaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EfectivoAsociado)events.get(0);
        Assertions.assertEquals("Efectivo-001", event.getEfectivoId().value());
    }

    private List<DomainEvent> history() {
        Estado estado = new Estado(EstadoEnum.INGRESADA);
        var event = new TulaCreada(estado);
        event.setAggregateRootId("Tula-001");
        return  List.of(event);
    }
}
