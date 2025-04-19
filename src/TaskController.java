import exceptions.TaskAlreadyExistsException;
import exceptions.TaskNotFoundException;
import exceptions.TaskNotUpdatedException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class TaskController {
    HashMap<Integer,Task> listTask = new HashMap<>();

    //Crear tareas (task)
    public void createTask(String nameTask) throws TaskAlreadyExistsException {
        if (listTask.isEmpty()){
            Task taskNew = new Task(nameTask);
            listTask.put(taskNew.getId(),taskNew);
            System.out.println("Task: " + taskNew.getDescription() + " created");
        }
        else {
            for (Task task : listTask.values()){
                if(Objects.equals(task.getDescription(), nameTask)){
                    throw new TaskAlreadyExistsException("The task " + nameTask + " already created");
                }
            }
            Task taskNew = new Task(nameTask);
            listTask.put(taskNew.getId(),taskNew);
            System.out.println("Task: " + taskNew.getDescription() + " created");
        }

    }
    //Listar tareas
    public HashMap<Integer, Task> getListTask() {
        return listTask;
    }

    //Listar una tarea
    public Task getTask(int id) throws TaskNotFoundException{
        if(!listTask.containsKey(id)){
            throw new TaskNotFoundException("The task with id " + id + " not exits");
        }
        return listTask.get(id);
    }

    // Modificar tarea
    public void updateTask(String taskNameNew, int idTask) throws TaskNotFoundException, TaskNotUpdatedException {
        Task taskToUpdate = getTask(idTask);
        Task currentValueTask = getTask(idTask);
        taskToUpdate.setDescription(taskNameNew);
        taskToUpdate.setUpdateAt(LocalDateTime.now());
        boolean isUpdated = listTask.replace(idTask,currentValueTask,taskToUpdate);
        if (!isUpdated){
            throw new TaskNotUpdatedException("The task " + taskToUpdate.getDescription() + "with id " + idTask + " " +
                    "can´t update");
        }
        System.out.println("the task " + currentValueTask.getDescription() + " updated to " + taskToUpdate.getDescription());
    }

    //Modificar status
    public void updateStatus(String statusNew, int idTask) throws TaskNotFoundException, TaskNotUpdatedException {
        Task taskToUpdate = getTask(idTask);
        Task currentValueTask = getTask(idTask);
        taskToUpdate.setStatus(statusNew);
        taskToUpdate.setUpdateAt(LocalDateTime.now());
        boolean isUpdated = listTask.replace(idTask,currentValueTask,taskToUpdate);
        if (!isUpdated){
            throw new TaskNotUpdatedException("The task " + taskToUpdate.getDescription() + "with id " + idTask + " " +
                    "can´t update the status");
        }
        System.out.println("the task " + currentValueTask.getDescription() + " updated to " + taskToUpdate.getStatus());
    }

    //Eliminar tarea
    public void deleteTask(int idTask) throws TaskNotFoundException {
        Task taskToDelete = getTask(idTask);
        boolean isDeleted = listTask.remove(idTask,taskToDelete);
        if (isDeleted){
            System.out.println("Task deleted");
        }
    }
}
