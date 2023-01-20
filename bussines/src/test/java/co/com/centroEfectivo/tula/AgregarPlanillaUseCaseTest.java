package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.revision.events.CajeroAgregado;
import co.com.centroEfectivo.revision.values.RevisionId;
import co.com.centroEfectivo.tula.commands.AgregarPlanilla;
import co.com.centroEfectivo.tula.events.PlanillaAgregada;
import co.com.centroEfectivo.tula.events.TulaCreada;
import co.com.centroEfectivo.tula.values.*;
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
public class AgregarPlanillaUseCaseTest {
    @InjectMocks
    private AgregarPlanillaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarPlanilla() {
        TulaId tulaId = TulaId.of("aaaaa");
        Fecha fecha = new Fecha(LocalDate.of(2023, 1, 20));
        Direccion direccion = new Direccion("Mz. 14 Casa 18, Tamasagra II Local 2, Pasto, Nariño");
        var command = new AgregarPlanilla(tulaId, fecha, direccion);

        when(repository.getEventsBy("aaaaa")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTulaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PlanillaAgregada)events.get(0);
        Assertions.assertEquals("Mz. 14 Casa 18, Tamasagra II Local 2, Pasto, Nariño", event.getDireccion().value());
        Assertions.assertEquals(LocalDate.of(2023, 1, 20), event.getFecha().value());
    }

    private List<DomainEvent> history() {
        Estado estado = new Estado(EstadoEnum.INGRESADA);
        var event = new TulaCreada(estado);
        event.setAggregateRootId("xxxxx");
        return  List.of(event);
    }
}
