package main.efectivo;

import co.com.centroEfectivo.efectivo.Efectivo;
import co.com.centroEfectivo.efectivo.commands.ActualizarCantidad;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarCantidadUseCase extends UseCase<RequestCommand<ActualizarCantidad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCantidad> actualizarCantidadRequestCommand) {
        var command = actualizarCantidadRequestCommand.getCommand();
        var efectivo = Efectivo.from(command.getEfectivoId(), retrieveEvents(command.getEfectivoId().value()));
        efectivo.actualizarCantidad(
                command.getEfectivoId(),
                command.getCantidad()
        );
        emit().onResponse(new ResponseEvents(efectivo.getUncommittedChanges()));
    }
}
