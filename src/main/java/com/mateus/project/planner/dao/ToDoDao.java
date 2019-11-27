package com.mateus.project.planner.dao;

import com.mateus.project.planner.model.ToDo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToDoDao {

    int insertToDo(UUID id, ToDo toDo);

    default int insertToDo(ToDo toDo) {
        UUID id = UUID.randomUUID();
        return insertToDo(id,toDo);
    }

    List<ToDo> getAllToDos();

    Optional<ToDo> selectToDoById(UUID id);

    int updateToDoById(UUID id, ToDo toDo);

    int deleteToDoById(UUID id);

}
