import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. Search task");
            System.out.println("5. Count tasks (Bonus)");
            System.out.println("6. Insert task at index (Bonus)");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    todoList.addTask(title);
                    break;

                case 2:
                    System.out.print("Enter task title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    todoList.deleteTask(deleteTitle);
                    break;

                case 3:
                    todoList.printTasks();
                    break;

                case 4:
                    System.out.print("Enter task title to search: ");
                    String searchTitle = scanner.nextLine();
                    if (todoList.contains(searchTitle)) {
                        System.out.println("\nTask found!");
                    } else {
                        System.out.println("\nTask not found.");
                    }
                    break;

                case 5:
                    System.out.println("\nTotal tasks: " + todoList.countTasks());
                    break;

                case 6:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter task title: ");
                    String taskAtIndex = scanner.nextLine();
                    todoList.insertTaskAt(index, taskAtIndex);
                    break;

                case 7:
                    System.out.println("\nExiting...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
