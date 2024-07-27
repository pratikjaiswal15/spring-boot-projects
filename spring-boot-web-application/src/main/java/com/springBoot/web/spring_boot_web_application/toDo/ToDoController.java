package com.springBoot.web.spring_boot_web_application.toDo;

import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    private ToDoController(ToDoService toDoService) {
        super();
        this.toDoService = toDoService;
    }
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {

        String username = getLoggedInUsername();
        List<ToDo> todos = toDoService.getToDosByUsername(username);
        model.put("todos", todos);
        return "toDos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddToDoPage(ModelMap model) {
        String username = (String)model.get("name");
        ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addToDo";
    }



    @RequestMapping(value="update-todo", method = RequestMethod.GET)    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        ToDo todo = toDoService.findById(id);
        model.addAttribute("todo", todo);
        return "addToDo";
    }


    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "update-todo";
        }

        String username = (String)model.get("name");
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewToDo(ModelMap model, @Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "addToDo";
        }

        String username = (String) model.get("name");
        toDoService.addToDo(username, todo.getDescription(),
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }


    @RequestMapping("delete-todo")
    public String deleteToDo(@RequestParam int id) {

        toDoService.deleteById(id);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
