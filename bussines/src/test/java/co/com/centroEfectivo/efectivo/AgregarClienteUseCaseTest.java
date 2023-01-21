package co.com.centroEfectivo.efectivo;


import co.com.centroEfectivo.efectivo.AgregarClienteUseCase;
import co.com.centroEfectivo.efectivo.commands.AgregarCliente;
import co.com.centroEfectivo.efectivo.events.ClienteAgregado;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
import co.com.centroEfectivo.efectivo.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarClienteUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarClienteHappyPass(){
        //arrage
        var command = new AgregarCliente(
                EfectivoId.of("12"),
                ClienteId.of("35"),
                new Nombre("GanaSA"),
                new Contacto("3045282540"),
                new Direccion("calle 40 #93D-98")
        );

        var agregarClienteUseCase = new AgregarClienteUseCase();

        when(repository.getEventsBy("12")).thenReturn(events());
        agregarClienteUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarClienteUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (ClienteAgregado)response.getDomainEvents().get(0);
        Assertions.assertEquals(EfectivoId.of("12"),event.getEfectivoId());
        Assertions.assertEquals(ClienteId.of("35"),event.getClienteId());
        Assertions.assertEquals("GanaSA",event.getNombre().value());
        Assertions.assertEquals("3045282540",event.getContacto().value());
        Assertions.assertEquals("calle 40 #93D-98",event.getDireccion().value());
    }

    private List<DomainEvent> events() {
        return List.of(new EfectivoCreado(
                new Cantidad(10),
                new Ubicacion(Ubicacion.UbicacionEnum.TULA)
        ));
    }

}