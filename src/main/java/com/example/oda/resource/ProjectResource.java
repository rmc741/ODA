package com.example.oda.resource;

import com.example.oda.dto.ProjectDTO;
import com.example.oda.entity.Project;
import com.example.oda.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "project")
@RequiredArgsConstructor
public class ProjectResource {
    private final ProjectService projectService;

    @GetMapping()
    public ResponseEntity<List<ProjectDTO>> findAll(){
        List<ProjectDTO> empresaDTOList = projectService.buscarTodos().stream()
                .map(obj -> new ProjectDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(empresaDTOList);
    }

    @GetMapping("{projectId}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable final Long projectId){
        ProjectDTO projectDTO = new ProjectDTO(projectService.buscarProjeto(projectId));

        return ResponseEntity.ok().body(projectDTO);
    }

    @PostMapping()
    public ResponseEntity<ProjectDTO> newProject(@RequestBody final ProjectDTO projectDTO){
        Project project = projectService.inserir(projectDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(project.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{projectId}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable final Long projectId, @RequestBody final ProjectDTO projectDTO){
        ProjectDTO updateProject = new ProjectDTO(projectService.atualizarDados(projectId, projectDTO));
        return ResponseEntity.ok().body(updateProject);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<Void> deleteProject(@PathVariable final Long Id){
        projectService.remover(Id);
        return ResponseEntity.noContent().build();
    }

}
