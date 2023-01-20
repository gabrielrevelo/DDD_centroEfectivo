package main.boveda;


import co.com.centroEfectivo.boveda.Boveda;
import co.com.centroEfectivo.boveda.commands.AsociarEfectivoABoveda;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsociarEfectivoUseCase extends UseCase<RequestCommand<AsociarEfectivoABoveda>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarEfectivoABoveda> asociarEfectivoABovedaRequestCommand) {
        var command = asociarEfectivoABovedaRequestCommand.getCommand();
        var boveda = Boveda.from(command.getBovedaId(), retrieveEvents(command.getBovedaId().value()));
        boveda.asociarEfectivoId(
                command.getBovedaId(),
                command.getEfectivoId()
        );
        emit().onResponse(new ResponseEvents(boveda.getUncommittedChanges()));
    }

}
