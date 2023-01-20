package co.com.centroEfectivo.revision;

import co.com.centroEfectivo.revision.commands.AgregarCajero;
import co.com.centroEfectivo.revision.commands.AgregarReporte;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarReporteUseCase extends UseCase<RequestCommand<AgregarReporte>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarReporte> agregarReporteRequestCommand) {
        var command = agregarReporteRequestCommand.getCommand();
        var revision = Revision.from(
                command.getRevisionId(),
                repository().getEventsBy(command.getRevisionId().value())
        );
        revision.agregarReporte(command.getFecha(), command.getNovedad());

        emit().onResponse(new ResponseEvents(revision.getUncommittedChanges()));
    }
}
