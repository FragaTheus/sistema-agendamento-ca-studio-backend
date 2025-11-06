package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.procedure;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcedureJpa extends JpaRepository<Procedure, Long>, JpaSpecificationExecutor<Procedure> {

    List<Procedure> findByIsActiveTrue();

    List<Procedure> findByCategory(String category);

    Procedure findByName(String name);

    boolean existsByName(String name);

    @Query("""
    SELECT p FROM Procedure p
    WHERE (:name IS NULL OR TRIM(:name) = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', TRIM(:name), '%')))
    AND (:category IS NULL OR p.category = :category)
    AND (:active IS NULL OR p.isActive = :active)
    """)
    List<Procedure> filterProcedures(
            @Param("name") String name,
            @Param("category") String category,
            @Param("active") Boolean isActive
    );


}
