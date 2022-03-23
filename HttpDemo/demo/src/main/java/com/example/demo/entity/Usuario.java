package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Endereco endereco;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Cartao cartao;
//
//    @CreationTimestamp
//    private Timestamp dataCriacao;

}
