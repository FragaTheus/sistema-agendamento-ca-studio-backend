package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.mapper;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command.FilterProcedureCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repositoryimpl.procedure.query.FilterObjectQuery;

public record QueryObjectMapper() {

    public static FilterObjectQuery fromCommand(FilterProcedureCommand command){
        return FilterObjectQuery.builder()
                .name(command.name())
                .category(command.category())
                .isActive(command.isActive())
                .build();
    }

}
