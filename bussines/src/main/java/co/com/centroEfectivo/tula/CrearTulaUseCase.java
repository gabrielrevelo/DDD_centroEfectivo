package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.tula.commands.CrearTula;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearTulaUseCase extends UseCase<RequestCommand<CrearTula>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTula> crearTulaRequestCommand) {
        var command = crearTulaRequestCommand.getCommand();

        var tula =  new Tula(command.getTulaId(), command.getEstado());

        emit().onResponse(new ResponseEvents(tula.getUncommittedChanges()));
    }
}
