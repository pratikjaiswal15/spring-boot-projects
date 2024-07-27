package com.spring.boot.spring_security_learning.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    public static final List<Todo> TODO_LIST = List.of(new Todo("pratik", "Learn DSA"),
            new Todo("pratik", "Learn System design"));

    @GetMapping("/todos")
    private List<Todo> retrieveAllTodos() {
        return TODO_LIST;
    }

    @GetMapping("/user/{username}/todos")
    private Todo retrieveAllTodosForUser(@PathVariable String username) {
        return TODO_LIST.get(0);
    }

    @PostMapping("/user/{username}/todos")
    private void createAllTodosForUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Creating todo {} for user {}", todo, username);
    }
}

record Todo(String username, String description){}
