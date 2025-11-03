package br.com.castudio.sistema_agendamento.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

}
