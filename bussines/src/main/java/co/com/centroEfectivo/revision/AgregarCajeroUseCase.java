package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.Revision;
import co.com.centroEfectivo.revision.commands.AgregarCajero;
import co.com.centroEfectivo.revision.entities.Cajero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarCajeroUseCase extends UseCase<RequestCommand<AgregarCajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCajero> agregarCajeroRequestCommand) {
        var command = agregarCajeroRequestCommand.getCommand();
        var revision = Revision.from(
                command.getRevisionId(),
                repository().getEventsBy(command.getRevisionId().value())
        );
        revision.agregarCajero(command.getNombre());

        emit().onResponse(new ResponseEvents(revision.getUncommittedChanges()));
    }
}
