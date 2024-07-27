package com.springBoot.web.spring_boot_web_application.toDo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static List<ToDo> toDos = new ArrayList<>();
    private static int totalCount = 0;

    static {
        toDos.add(new ToDo(++totalCount, "pratik", "Learn Spring boot 1", LocalDate.now().plusYears(1), false));
        toDos.add(new ToDo(++totalCount, "pratik", "Learn DSA 1 ", LocalDate.now().plusMonths(2), false));
        toDos.add(new ToDo(++totalCount, "pratik", "Learn System Design 1 ", LocalDate.now().plusWeeks(4), false));
        toDos.add(new ToDo(++totalCount, "pratik", "Learn Spring boot 1", LocalDate.now().plusMonths(4), false));

    }

    public List<ToDo> getToDosByUsername(String username) {
        Predicate<? super ToDo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return toDos.stream().filter(predicate).toList();
    }

    public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
        ToDo newTodo = new ToDo(++totalCount, username, description, targetDate, done);
        System.out.println(newTodo);
        toDos.add(newTodo);
    }

    public void deleteById(int id) {
        Predicate<? super ToDo> predicate = toDos -> toDos.getId() == id;
        toDos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        return toDos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(ToDo toDo) {
        System.out.println("in update todo");
        System.out.println(toDo);
        deleteById(toDo.getId());
        System.out.println(toDos);
        toDos.add(toDo);
    }


}
