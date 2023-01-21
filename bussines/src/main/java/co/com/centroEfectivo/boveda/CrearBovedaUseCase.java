package co.com.centroEfectivo.boveda;

import co.com.centroEfectivo.boveda.Boveda;
import co.com.centroEfectivo.boveda.commands.CrearBoveda;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearBovedaUseCase extends UseCase<RequestCommand<CrearBoveda>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearBoveda> crearBovedaRequestCommand) {
    var command = crearBovedaRequestCommand.getCommand();
    var boveda = new Boveda(command.getBovedaId(),command.getEfectivoTotal());

    emit().onResponse(new ResponseEvents(boveda.getUncommittedChanges()));
    }
}
