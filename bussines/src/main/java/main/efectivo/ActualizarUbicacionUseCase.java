package main.efectivo;

import co.com.centroEfectivo.efectivo.Efectivo;
import co.com.centroEfectivo.efectivo.commands.ActualizarUbicacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarUbicacionUseCase extends UseCase<RequestCommand<ActualizarUbicacion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarUbicacion> actualizarUbicacionRequestCommand) {
        var command = actualizarUbicacionRequestCommand.getCommand();

        var efectivo = Efectivo.from(
                command.getEfectivoId(), repository().getEventsBy(command.getEfectivoId().value())
        );
        efectivo.actualizarUbicacion(command.getUbicacion());

        emit().onResponse(new ResponseEvents(efectivo.getUncommittedChanges()));

    }
}
