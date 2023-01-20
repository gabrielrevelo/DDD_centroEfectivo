package co.com.centroEfectivo.efectivo;

import co.com.centroEfectivo.efectivo.Efectivo;
import co.com.centroEfectivo.efectivo.commands.CrearEfectivo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearEfectivoUseCase extends UseCase<RequestCommand<CrearEfectivo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEfectivo> crearEfectivoRequestCommand) {
    var command = crearEfectivoRequestCommand.getCommand();
    var efectivo = new Efectivo(command.getEfectivoId(),command.getCantidad(),command.getUbicacion());

    emit().onResponse(new ResponseEvents(efectivo.getUncommittedChanges()));
    }
}
