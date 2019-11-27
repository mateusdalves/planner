package com.mateus.project.planner.api;

import com.mateus.project.planner.model.ToDo;
import com.mateus.project.planner.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/planner")
@RestController
public class PlannerController {
    private final ToDoService toDoService;

    @Autowired
    public PlannerController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping
    public void addToDo(@RequestBody ToDo toDo){
        this.toDoService.addToDo(toDo);
    }

    @GetMapping
    public List<ToDo> getToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping(path = "{id}")
    public ToDo getToDoById(@PathVariable("id") UUID id){
        return toDoService.getToDoById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteToDoById(@PathVariable("id") UUID id){
        toDoService.deleteToDo(id);
    }

    @PutMapping(path = "{id}")
    public void updateToDo(@PathVariable("id") UUID id, @RequestBody ToDo toDoToUpdate){
        toDoService.updateToDo(id, toDoToUpdate);
    }

}
