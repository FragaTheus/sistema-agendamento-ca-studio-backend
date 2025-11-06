package br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class Procedure {

    protected Procedure() {
    }

    public Procedure(Long id, String name, String description, String category, BigDecimal price, Integer duration, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = CategoryEnum.fromString(category);
        this.price = price;
        this.duration = duration;
        this.isActive = isActive;
    }

    public Procedure(String name, String description, String category, BigDecimal price, Integer duration, boolean isActive) {
        this.name = name;
        this.description = description;
        this.category = CategoryEnum.fromString(category);
        this.price = price;
        this.duration = duration;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private CategoryEnum category;

    @Getter
    @Setter
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Getter
    @Setter
    private Integer duration;

    @Getter
    @Setter
    private boolean isActive;



}
