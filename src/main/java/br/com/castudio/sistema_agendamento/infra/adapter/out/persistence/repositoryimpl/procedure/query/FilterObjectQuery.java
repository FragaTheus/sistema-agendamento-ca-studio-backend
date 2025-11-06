package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repositoryimpl.procedure.query;

import lombok.Builder;

@Builder
public record FilterObjectQuery(
        String name,
        String category,
        Boolean isActive
) {
}
