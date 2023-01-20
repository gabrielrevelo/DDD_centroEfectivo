package co.com.centroEfectivo;

import co.com.centroEfectivo.revision.commands.CrearRevision;
import co.com.centroEfectivo.revision.events.RevisionCreada;
import co.com.centroEfectivo.revision.values.Cubiculo;
import co.com.centroEfectivo.revision.values.RevisionId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearRevisionUseCaseTest {

    private CrearRevisionUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearRevisionUseCase();
    }

    @Test
    public void crearRevision(){
        RevisionId revisionId = RevisionId.of("aaaa");
        Cubiculo cubiculo = new Cubiculo(10);
        var command = new CrearRevision(revisionId, cubiculo);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var revisionCreada = (RevisionCreada)events.get(0);
        Assertions.assertEquals("aaaa", revisionCreada.aggregateRootId());
        Assertions.assertEquals(10, revisionCreada.getCubiculo().value());
    }
}
