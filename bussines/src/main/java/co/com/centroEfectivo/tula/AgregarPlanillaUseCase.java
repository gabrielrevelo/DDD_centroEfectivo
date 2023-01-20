package co.com.centroEfectivo.tula;

import co.com.centroEfectivo.tula.commands.AgregarPlanilla;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPlanillaUseCase extends UseCase<RequestCommand<AgregarPlanilla>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlanilla> agregarPlanillaRequestCommand) {
        var command = agregarPlanillaRequestCommand.getCommand();
        var tula = Tula.from(
                command.getTulaId(),
                repository().getEventsBy(command.getTulaId().value())
        );
        tula.agregarPlanilla(command.getFecha(), command.getDireccion());

        emit().onResponse(new ResponseEvents(tula.getUncommittedChanges()));
    }
}
