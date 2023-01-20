package main.efectivo;

import co.com.centroEfectivo.efectivo.Efectivo;
import co.com.centroEfectivo.efectivo.commands.AgregarCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {
        var command = agregarClienteRequestCommand.getCommand();
        var efectivo = Efectivo.from(command.getEfectivoId(), retrieveEvents(command.getEfectivoId().value()));
        efectivo.agregarCliente(
                command.getEfectivoId(),
                command.getClienteId(),
                command.getNombre(),
                command.getContacto(),
                command.getDireccion()
        );
        emit().onResponse(new ResponseEvents(efectivo.getUncommittedChanges()));
    }
}
