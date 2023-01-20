package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.revision.Revision;
import co.com.centroEfectivo.tula.commands.AsociarEfectivo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsociarEfectivoUseCase extends UseCase<RequestCommand<AsociarEfectivo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarEfectivo> asociarEfectivoRequestCommand) {
        var command = asociarEfectivoRequestCommand.getCommand();
        var tula = Tula.from(
                command.getTulaId(),
                repository().getEventsBy(command.getTulaId().value())
        );
        tula.asociarEfectivo(command.getEfectivoId());

        emit().onResponse(new ResponseEvents(tula.getUncommittedChanges()));
    }
}
