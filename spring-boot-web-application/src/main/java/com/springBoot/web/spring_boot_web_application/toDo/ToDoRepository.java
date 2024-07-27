package com.springBoot.web.spring_boot_web_application.toDo;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    public List<ToDo> findByUsername(String username);


}
