package com.mateus.project.planner.dao;

import com.mateus.project.planner.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class ToDoDataAcessService implements ToDoDao{
    @Override
    public int insertToDo(UUID id, ToDo toDo) {
        return 0;
    }

    @Override
    public List<ToDo> getAllToDos() {
        return List.of(new ToDo(UUID.randomUUID(), "FROM MYSQL","FROM MYSQL"));
    }

    @Override
    public Optional<ToDo> selectToDoById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int updateToDoById(UUID id, ToDo toDo) {
        return 0;
    }

    @Override
    public int deleteToDoById(UUID id) {
        return 0;
    }
}
