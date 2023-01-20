package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.tula.commands.CrearTula;
import co.com.centroEfectivo.tula.events.TulaCreada;
import co.com.centroEfectivo.tula.values.Estado;
import co.com.centroEfectivo.tula.values.EstadoEnum;
import co.com.centroEfectivo.tula.values.TulaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearTulaUseCaseTest {

    private CrearTulaUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearTulaUseCase();
    }

    @Test
    public void crearTula() {
        TulaId tulaId = TulaId.of("1111");
        Estado estado = new Estado(EstadoEnum.INGRESADA);
        var command = new CrearTula(tulaId, estado);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var tulaCreada = (TulaCreada) events.get(0);
        Assertions.assertEquals("1111", tulaCreada.aggregateRootId());
        Assertions.assertEquals(EstadoEnum.INGRESADA, tulaCreada.getEstado().value());
    }
}
