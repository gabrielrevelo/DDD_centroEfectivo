package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.commands.AgregarReporte;
import co.com.centroEfectivo.revision.events.ReporteAgregado;
import co.com.centroEfectivo.revision.events.RevisionCreada;
import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.centroEfectivo.revision.values.Fecha;
import co.com.centroEfectivo.revision.values.Novedad;
import co.com.centroEfectivo.revision.values.RevisionId;
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

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarReporteUseCaseTest {
    @InjectMocks
    private AgregarReporteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarReporte () {
        var command = new AgregarReporte(
                RevisionId.of("Revision-001"),
                new Fecha(LocalDate.of(2023, 1, 20)),
                new Novedad("Ninguna")
        );

        when(repository.getEventsBy("Revision-001")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRevisionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ReporteAgregado)events.get(0);
        Assertions.assertEquals(LocalDate.of(2023, 1, 20), event.getFecha().value());
        Assertions.assertEquals("Ninguna", event.getNovedad().value());
    }

    private List<DomainEvent> history() {
        Cubiculo cubiculo = new Cubiculo(10);
        var event = new RevisionCreada(cubiculo);
        event.setAggregateRootId("Revision-001");
        return List.of(event);
    }
}
