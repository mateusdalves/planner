package com.mateus.project.planner.service;

import com.mateus.project.planner.dao.ToDoDao;
import com.mateus.project.planner.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ToDoService {

    private final ToDoDao toDoDao;

    @Autowired
    public ToDoService(@Qualifier("fakeDao") ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    public int addToDo(ToDo toDo) {
        return toDoDao.insertToDo(toDo);
    }

    public List<ToDo> getAllToDos() {
        return toDoDao.getAllToDos();
    }

    public Optional<ToDo> getToDoById(UUID id) {
        return toDoDao.selectToDoById(id);
    }

    public int deleteToDo(UUID id) {
        return toDoDao.deleteToDoById(id);
    }

    public int updateToDo(UUID id, ToDo newToDo) {
        return toDoDao.updateToDoById(id, newToDo);
    }

}
