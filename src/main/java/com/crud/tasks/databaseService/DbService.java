package com.crud.tasks.databaseService;

import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.task.Task;
import com.crud.tasks.task.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(final Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException());
    }

    public Task saveTask(final Task task) {
        return taskRepository.save(task);
    }
    public void deleteTask(final Long id) {
        taskRepository.deleteById(id);
    }

}
