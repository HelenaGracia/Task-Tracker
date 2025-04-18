import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
       TaskController taskController = new TaskController();
       taskController.createTask("Lavar los platos");
       System.out.println(taskController.getListTask());
       taskController.createTask("Limpiar la mesa");
       System.out.println(taskController.getListTask());
       taskController.updateTask("Barrer", 1);
       System.out.println(taskController.getListTask());
       taskController.updateStatus("done", 1);
       System.out.println(taskController.getListTask());
       taskController.deleteTask(2);
       System.out.println(taskController.getListTask());




    }
}