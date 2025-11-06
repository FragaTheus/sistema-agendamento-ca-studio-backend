package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.implementation;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command.FilterProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command.UpdateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.contract.ProcedureService;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.mapper.ProcedureMapper;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.mapper.QueryObjectMapper;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.enums.CategoryEnum;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.exception.ProcedureAlreadyExists;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.exception.SamePriceException;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.repository.ProcedureRepository;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repositoryimpl.procedure.query.FilterObjectQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository repository;

    @Override
    public Procedure saveProcedure(Procedure procedure) {
        return repository.save(procedure);
    }

    @Override
    public Procedure findProcedureById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Procedure> findAllProcedures() {
        return repository.findAll();
    }

    @Override
    public List<Procedure> findActiveProcedures() {
        return repository.findByActiveIsTrue();
    }

    @Override
    public List<Procedure> findProcedureByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public Procedure findProcedureByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public boolean existProcedureByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void deleteProcedure(Procedure procedure) {
        repository.delete(procedure);
    }

    @Override
    public void  createProcedure(CreateProcedureCommand command) {
        if (existProcedureByName(command.name())){
            throw new ProcedureAlreadyExists();
        }
        Procedure procedure = ProcedureMapper.fromCommand(command);
    }

    @Override
    public Procedure updateProcedure(UpdateProcedureCommand command) {
        Procedure procedure = findProcedureByName(command.name());

        if (command.description() != null && !command.description().isBlank()){
            procedure.setDescription(command.description());
        }

        if (command.category() != null && !command.category().isBlank()){
            procedure.setCategory(CategoryEnum.valueOf(command.category().toUpperCase()));
        }

        if (command.price() != null && !command.price().isBlank()){
            BigDecimal newPrice = new BigDecimal(command.price());
            if (newPrice.compareTo(procedure.getPrice()) == 0){
                throw new SamePriceException();
            }
            procedure.setPrice(new BigDecimal(command.price()));
        }

        if (command.duration() != null){
            procedure.setDuration(command.duration());

        }

        return saveProcedure(procedure);
    }

    @Override
    public Procedure toggleProcedureStatus(Long id) {
        Procedure procedure = repository.findById(id);
        procedure.setActive(!procedure.isActive());
        return procedure;
    }

    @Override
    public List<Procedure> filterProcedures(FilterProcedureCommand command) {
        FilterObjectQuery objectQuery = QueryObjectMapper.fromCommand(command);
        return repository.filterProcedures(objectQuery);
    }
}
