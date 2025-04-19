import exceptions.TaskAlreadyExistsException;
import exceptions.TaskNotFoundException;
import exceptions.TaskNotUpdatedException;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      //Creación objeto scanner para poder recibir los inptus del usuario a través de la cli
       Scanner scanner = new Scanner(System.in);
       TaskController taskController = new TaskController();
       boolean isEnded = false; //Variable de control para finalizar el programa
       boolean isCorrect = false;
       int numOfAction = 0;
       while (!isEnded){
          System.out.println("Seleccione el número de la acción que desea realizar: ");
          System.out.println("1.Crear tarea");
          System.out.println("2.Modificar tarea");
          System.out.println("3.Modificar status tarea");
          System.out.println("4.Eliminar tarea");
          System.out.println("5.Ver lista de tareas");
          System.out.println("6.Finalizar programa");
          try {
             while (!isCorrect){
                 numOfAction = scanner.nextInt(); //input del usuario del número de opcíon elegida
                if (numOfAction < 1 || numOfAction > 6){
                   System.out.println("Error, debe introducir un número entre 1 o 6");
                }
                else {
                   isCorrect = true;
                }

             }
             int id = 0; // Input del usuario del id de la tarea
             scanner.nextLine();
             String descriptionTask = " "; //Input del usuario sobre la descripcion de la tarea o su
             switch (numOfAction){
                case 1:
                   System.out.println("Introduzca breve descripción de la tarea: ");
                   while (descriptionTask.isBlank()){
                      descriptionTask = scanner.nextLine();
                   }
                   taskController.createTask(descriptionTask);
                   isCorrect = false;
                   break;
                case 2:
                   System.out.println("Introduzca el id de la tarea que desea actualizar: ");
                   id = scanner.nextInt();
                   System.out.println("Introduzca la nueva descripción: ");
                   while (descriptionTask.isBlank()){
                      descriptionTask = scanner.nextLine();
                   }
                   taskController.updateTask(descriptionTask,id);
                   isCorrect = false;
                   break;
                case 3:
                   System.out.println("Introduzca el id de la tarea que desea actualizar el status: ");
                   id = scanner.nextInt();
                   System.out.println("Introduzca el nuevo status: ");
                   while (descriptionTask.isBlank()){
                      descriptionTask = scanner.nextLine();
                   }
                   taskController.updateStatus(descriptionTask,id);
                   isCorrect = false;
                   break;
                case 4:
                   System.out.println("Introduzca el id de la tarea que desea eliminar: ");
                   id = scanner.nextInt();
                   taskController.deleteTask(id);
                   isCorrect = false;
                   break;
                case 5:
                   if (taskController.getListTask().isEmpty()){
                      System.out.println("La lista de tareas está vacía");
                   }else {
                      for(Map.Entry<Integer,Task> entry : taskController.getListTask().entrySet()){
                         System.out.println(entry.getValue());
                      }
                   }
                   isCorrect = false;
                   break;
                case 6:
                   isEnded = true;
             }
          }catch (InputMismatchException e){
             System.out.println("Error, no ha introducido un número");
             scanner.nextLine();
             isCorrect = false;
            }
          catch (TaskNotFoundException | TaskNotUpdatedException | TaskAlreadyExistsException e){
             System.out.println(e.getMessage());
             isCorrect = false;
          }
       }
    }
}