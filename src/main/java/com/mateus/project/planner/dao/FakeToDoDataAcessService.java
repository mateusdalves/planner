package com.mateus.project.planner.dao;

import com.mateus.project.planner.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeToDoDataAcessService implements ToDoDao {


    private static List<ToDo> DB = new ArrayList<>();

    @Override
    public int insertToDo(UUID id, ToDo toDo) {
        DB.add(new ToDo(id, toDo.getName(), toDo.getDescription()));
        return 1;
    }

    @Override
    public List<ToDo> getAllToDos() {
        return DB;
    }

    @Override
    public Optional<ToDo> selectToDoById(UUID id) {
        return DB.stream()
                .filter(toDo -> toDo.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateToDoById(UUID id, ToDo update) {
        return selectToDoById(id)
                .map(toDo -> {
                    int indexOfToDoToUpdate = DB.indexOf(toDo);
                    if (indexOfToDoToUpdate >= 0){
                        DB.set(indexOfToDoToUpdate, new ToDo(id, update.getName(), update.getDescription()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deleteToDoById(UUID id) {
        Optional<ToDo> toDoMaybe = selectToDoById(id);
        if(toDoMaybe.isEmpty()){
            return 0;
        }
        DB.remove(toDoMaybe.get());
        return 1;
    }

}
