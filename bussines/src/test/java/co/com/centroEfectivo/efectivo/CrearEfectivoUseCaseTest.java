package co.com.centroEfectivo.efectivo;


import co.com.centroEfectivo.efectivo.CrearEfectivoUseCase;
import co.com.centroEfectivo.efectivo.commands.CrearEfectivo;
import co.com.centroEfectivo.efectivo.events.EfectivoCreado;
import co.com.centroEfectivo.efectivo.values.Cantidad;
import co.com.centroEfectivo.efectivo.values.EfectivoId;
import co.com.centroEfectivo.efectivo.values.Ubicacion;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearEfectivoUseCaseTest {

    private CrearEfectivoUseCase useCase;

    @BeforeEach
    public void setup() {useCase = new CrearEfectivoUseCase();};

    @Test
    public void crearEfectivoHappyPass(){
        //arrange
        EfectivoId efectivoId = EfectivoId.of("1010");
        Cantidad cantidad = new Cantidad(1300);
        Ubicacion ubicacion = new Ubicacion(Ubicacion.UbicacionEnum.TULA);

        var command = new CrearEfectivo(efectivoId,cantidad,ubicacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var efectivoCreado = (EfectivoCreado)events.get(0);
        Assertions.assertEquals("1010",efectivoCreado.aggregateRootId());
        Assertions.assertEquals(1300,efectivoCreado.getCantidad().value());
        Assertions.assertEquals(Ubicacion.UbicacionEnum.TULA,efectivoCreado.getUbicacion().value());
    }

}