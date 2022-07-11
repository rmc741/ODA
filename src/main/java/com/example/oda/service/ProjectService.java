package com.example.oda.service;

import com.example.oda.dto.ProjectDTO;
import com.example.oda.entity.Project;
import com.example.oda.exception.ObjectNotFoundException;
import com.example.oda.repository.ProjectRepositoy;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepositoy projectRepositoy;

    public ProjectService(ProjectRepositoy projectRepositoy) {
        this.projectRepositoy = projectRepositoy;
    }

    public List<Project> buscarTodos() {return projectRepositoy.findAll();}

    public Project buscarProjeto(final Long projectId){
        Optional<Project> project = projectRepositoy.findById(projectId);

        return project.orElseThrow(() -> new ObjectNotFoundException("Projeto não localizado!"));
    }

    public Project inserir(final ProjectDTO projectDTO){
        return projectRepositoy.save(new Project(projectDTO.getNomeProject() , projectDTO.getDescricaoProject() ));
    }

    public Project atualizarDados(final Long projectId , @Valid final ProjectDTO projectDTO){
        Project project = buscarProjeto(projectId);

        project.setNomeProjeto(projectDTO.getNomeProject());
        project.setDescricaoProjeto(projectDTO.getDescricaoProject());

        return projectRepositoy.save(project);
    }

    public void remover(final Long projectId){
        Project project = buscarProjeto(projectId);

        projectRepositoy.delete(project);
    }
}
