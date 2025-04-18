import java.time.LocalDateTime;
import java.util.HashMap;

public class TaskController {
    HashMap<Integer,Task> listTask = new HashMap<>();

    //Crear tareas (task)
    public void createTask(String nameTask){
        Task taskNew = new Task(nameTask);
        listTask.put(taskNew.getId(),taskNew);
        System.out.println("Task: " + taskNew.getDescription() + " created");
    }
    //Listar tareas
    public HashMap<Integer, Task> getListTask() {
        return listTask;
    }

    // Modificar tarea
    public void updateTask(String taskNameNew, int idTask){
        Task taskToUpadte = listTask.get(idTask);
        Task currentValueTask = listTask.get(idTask);
        taskToUpadte.setDescription(taskNameNew);
        taskToUpadte.setUpdateAt(LocalDateTime.now());
        boolean isUpdated = listTask.replace(idTask, currentValueTask, taskToUpadte);
        if (isUpdated){
            System.out.println("tarea actualizada");
        }else {
            taskToUpadte.setDescription(currentValueTask.getDescription());
            taskToUpadte.setUpdateAt(currentValueTask.getUpdateAt());
            System.out.println("Error en la actualizacion, restableciendo valores");
        }
    }

    //Modificar status
    public void updateStatus(String statusNew, int idTask){
        Task taskToUpdate = listTask.get(idTask);
        Task currentValueTask = listTask.get(idTask);
        taskToUpdate.setStatus(statusNew);
        taskToUpdate.setUpdateAt(LocalDateTime.now());
        boolean isUpdated = listTask.replace(idTask,currentValueTask,taskToUpdate);
        if (isUpdated){
            System.out.println("status actualizado");
        }else {
            taskToUpdate.setStatus(currentValueTask.getStatus());
            taskToUpdate.setUpdateAt(currentValueTask.getUpdateAt());
            System.out.println("Error en la actualizacion, restableciendo valores");
        }
    }

    //Eliminar tarea
    public void deleteTask(int idTask){
        Task taskToDelete = listTask.get(idTask);
        boolean isDeleted = listTask.remove(idTask,taskToDelete);
        if (isDeleted){
            System.out.println("Tarea eliminada");
        }else {
            System.out.println("La tarea no se ha eliminado");
        }
    }

}
