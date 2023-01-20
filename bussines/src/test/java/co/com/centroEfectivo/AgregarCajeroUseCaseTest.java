package co.com.centroEfectivo;

import co.com.centroEfectivo.revision.commands.AgregarCajero;
import co.com.centroEfectivo.revision.events.CajeroAgregado;
import co.com.centroEfectivo.revision.events.RevisionCreada;
import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.centroEfectivo.revision.values.Nombre;
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

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarCajeroUseCaseTest {
    @InjectMocks
    private AgregarCajeroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarCajero() {
        RevisionId revisionId = RevisionId.of("aaaaa");
        Nombre nombre = new Nombre("Gabriel");
        var command = new AgregarCajero(revisionId, nombre);

        when(repository.getEventsBy("aaaaa")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRevisionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CajeroAgregado)events.get(0);
        Assertions.assertEquals("Gabriel", event.getNombre().value());
    }

    private List<DomainEvent> history() {
        Cubiculo cubiculo = new Cubiculo(10);
        var event = new RevisionCreada(cubiculo);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
