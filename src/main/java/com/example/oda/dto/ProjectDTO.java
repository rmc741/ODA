package com.example.oda.dto;

import com.example.oda.entity.Project;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProjectDTO {

    private Long id;
    private String nomeProject;
    private String descricaoProject;

    public ProjectDTO(final Project project) {
        this.id = project.getId();
        this.nomeProject = project.getNomeProjeto();
        this.descricaoProject = project.getDescricaoProjeto();
    }
}
