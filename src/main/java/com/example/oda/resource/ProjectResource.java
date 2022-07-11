package com.example.oda.resource;

import com.example.oda.dto.ProjectDTO;
import com.example.oda.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "project")
@RequiredArgsConstructor
public class ProjectResource {
    private final ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDTO>> findAll(){
        List<ProjectDTO> empresaDTOList = projectService.buscarTodos().stream()
                .map(obj -> new ProjectDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(empresaDTOList);


    }

}
