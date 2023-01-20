package co.com.centroEfectivo;

import co.com.centroEfectivo.revision.Revision;
import co.com.centroEfectivo.revision.commands.AgregarCajero;
import co.com.centroEfectivo.revision.commands.CrearRevision;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearRevisionUseCase extends UseCase<RequestCommand<CrearRevision>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearRevision> crearRevisionRequestCommand) {
        var command = crearRevisionRequestCommand.getCommand();

        var revision =  new Revision(command.getRevisionId(), command.getCubiculo());

        emit().onResponse(new ResponseEvents(revision.getUncommittedChanges()));
    }
}
