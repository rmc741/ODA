package com.example.oda.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "project_tbl")
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")
    private String nomeProjeto;
    @Column(name = "project_description")
    private String descricaoProjeto;

    public Project(String nomeProjeto, String descricaoProjeto) {
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
    }
}
