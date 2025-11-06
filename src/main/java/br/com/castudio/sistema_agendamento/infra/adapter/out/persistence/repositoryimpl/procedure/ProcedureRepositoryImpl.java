package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repositoryimpl.procedure;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.repository.ProcedureRepository;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.procedure.ProcedureJpa;
import br.com.castudio.sistema_agendamento.infra.exceptions.DataBaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProcedureRepositoryImpl implements ProcedureRepository {

    private final ProcedureJpa jpa;

    @Override
    public Procedure save(Procedure procedure) {
        try {
            return jpa.save(procedure);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public Procedure findById(Long id) {
        return jpa.findById(id).orElseThrow(()-> new DataBaseException());
    }

    @Override
    public List<Procedure> findAll() {
        try {
            return jpa.findAll();
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public List<Procedure> findByActiveIsTrue() {
        try{
            return jpa.findByActiveIsTrue();
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public List<Procedure> findByCategory(String category) {
        try {
            return jpa.findByCategory(category);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public Procedure findByName(String name) {
        try {
            return jpa.findByName(name);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public void delete(Procedure procedure) {
        try {
            jpa.delete(procedure);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public boolean existsByName(String name) {
        return jpa.exitsByName(name);
    }
}
