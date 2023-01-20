package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.tula.commands.ActualizarEstado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEstadoUseCase extends UseCase<RequestCommand<ActualizarEstado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstado> actualizarEstadoRequestCommand) {
        var command = actualizarEstadoRequestCommand.getCommand();
        var tula = Tula.from(
                command.getTulaId(), repository().getEventsBy(command.getTulaId().value())
        );
        tula.actualizarEstado(command.getEstado());

        emit().onResponse(new ResponseEvents(tula.getUncommittedChanges()));
    }
}
