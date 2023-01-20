package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.commands.AsociarTula;
import co.com.centroEfectivo.revision.events.RevisionCreada;
import co.com.centroEfectivo.revision.events.TulaAsociada;
import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.centroEfectivo.revision.values.RevisionId;
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
public class AsociarTulaUseCaseTest {
    @InjectMocks
    private AsociarTulaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asociarTula() {
        var command = new AsociarTula(
                RevisionId.of("Revision-001"),
                TulaId.of("Tula-001")
        );

        when(repository.getEventsBy("Revision-001")).thenReturn((history()));

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRevisionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TulaAsociada)events.get(0);
        Assertions.assertEquals("Tula-001", event.getTulaId().value());
    }

    private List<DomainEvent> history() {
        Cubiculo cubiculo = new Cubiculo(10);
        var event = new RevisionCreada(cubiculo);
        event.setAggregateRootId("Revision-001");
        return List.of(event);
    }
}
