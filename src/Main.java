import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      //Creación objeto scanner para poder recibir los inptus del usuario a través de la cli
       Scanner scanner = new Scanner(System.in);
       TaskController taskController = new TaskController();
       boolean isEnded = false; //Variable de control para finalizar el programa
       while (!isEnded){
          System.out.println("Seleccione el número de la acción que desea realizar: ");
          System.out.println("1.Crear tarea");
          System.out.println("2.Modificar tarea");
          System.out.println("3.Modificar status tarea");
          System.out.println("4.Eliminar tarea");
          System.out.println("5.Ver lista de tareas");
          System.out.println("6.Finalizar programa");
          int numOfAction = scanner.nextInt(); //input del usuario del número de opcíon elegida
          String descriptionTask = " "; //Input del usuario sobre la descripcion de la tarea o su status
          int id = 0; // Input del usuario del id de la tarea

          switch (numOfAction){
             case 1:
                System.out.println("Introduzca breve descripción de la tarea: ");
                while (descriptionTask.isBlank()){
                   descriptionTask = scanner.nextLine();
                }
                taskController.createTask(descriptionTask);
                break;
             case 2:
                System.out.println("Introduzca el id de la tarea que desea actualizar: ");
                id = scanner.nextInt();
                System.out.println("Introduzca la nueva descripción: ");
                while (descriptionTask.isBlank()){
                   descriptionTask = scanner.nextLine();
                }
                taskController.updateTask(descriptionTask,id);
                break;
             case 3:
                System.out.println("Introduzca el id de la tarea que desea actualizar el status: ");
                id = scanner.nextInt();
                System.out.println("Introduzca el nuevo status: ");
                while (descriptionTask.isBlank()){
                   descriptionTask = scanner.nextLine();
                }
                taskController.updateStatus(descriptionTask,id);
                break;
             case 4:
                System.out.println("Introduzca el id de la tarea que desea eliminar: ");
                id = scanner.nextInt();
                taskController.deleteTask(id);
                break;
             case 5:
                System.out.println(taskController.getListTask());
                break;
             case 6:
                isEnded = true;
          }
       }







    }
}