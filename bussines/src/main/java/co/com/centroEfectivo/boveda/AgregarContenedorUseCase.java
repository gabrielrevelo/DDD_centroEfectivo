package co.com.centroEfectivo.boveda;

import co.com.centroEfectivo.boveda.Boveda;
import co.com.centroEfectivo.boveda.commands.AgregarContendor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class AgregarContenedorUseCase extends UseCase<RequestCommand<AgregarContendor>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarContendor> agregarContendorRequestCommand) {
        var command = agregarContendorRequestCommand.getCommand();
        var boveda = Boveda.from(command.getBovedaId(), retrieveEvents(command.getBovedaId().value()));
        boveda.agregarContenedor(
                command.getBovedaId(),
                command.getContenedorId(),
                command.getCapacidadMaxima(),
                command.getCapacidadActual()
        );
        emit().onResponse(new ResponseEvents(boveda.getUncommittedChanges()));
    }
}
