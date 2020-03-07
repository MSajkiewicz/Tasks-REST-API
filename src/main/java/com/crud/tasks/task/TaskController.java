package com.crud.tasks.task;

import com.crud.tasks.databaseService.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private DbService dbService;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDTO> getTasks() {
        return taskMapper.mapToTaskDTOList(dbService.getAllTasks());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDTO getTask(@RequestParam Long taskId) {
        return taskMapper.mapToTaskDTO(dbService.getTask(taskId));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId) {
        dbService.deleteTask(taskId);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDto) {
        return taskMapper.mapToTaskDTO(dbService.saveTask(taskMapper.mapToTask(taskDto)));
    }
    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(TaskDTO taskDto) {
    }


}
