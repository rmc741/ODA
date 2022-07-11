package com.example.oda.repository;

import com.example.oda.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoy extends JpaRepository<Project,Long> {


}
