package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.commands.AsociarTula;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsociarTulaUseCase extends UseCase<RequestCommand<AsociarTula>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarTula> asociarTulaRequestCommand) {
        var command = asociarTulaRequestCommand.getCommand();
        var revision = Revision.from(
                command.getRevisionId(),
                repository().getEventsBy(command.getRevisionId().value())
        );
        revision.asociarTula(command.getTulaId());

        emit().onResponse(new ResponseEvents(revision.getUncommittedChanges()));
    }
}
