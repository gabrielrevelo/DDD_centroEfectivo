package co.com.centroEfectivo.boveda;

import co.com.centroEfectivo.boveda.Boveda;
import co.com.centroEfectivo.boveda.commands.ActualizarCapacidadActualDeContenedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class ActualizarCapacidadActualDeContenedorUseCase extends UseCase<RequestCommand<ActualizarCapacidadActualDeContenedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarCapacidadActualDeContenedor> actualizarCapacidadActualDeContenedorRequestCommand) {
        var command = actualizarCapacidadActualDeContenedorRequestCommand.getCommand();

        var boveda = Boveda.from(command.getBovedaId(), repository().getEventsBy(command.getBovedaId().value()));
        boveda.actualizarCapacidadActualDeUnContenedor(command.getContenedorId(),command.getCapacidadActual());

        emit().onResponse(new ResponseEvents(boveda.getUncommittedChanges()));



    }
}
