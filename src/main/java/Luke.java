import java.util.Scanner;

public class Luke {
    public static void echo(List list) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        while (!input.equals("bye")) {
            switch (input.split(" ", 2)[0]) {
            case "list":
                list.listTasks();
                break;
            case "mark":
                list.markTaskAsDone(Integer.parseInt(input.split(" ")[1]) - 1);
                break;
            case "unmark":
                list.markTaskAsNotDone(Integer.parseInt(input.split(" ")[1]) - 1);
                break;
            case "todo":
                list.addTask(new Todo(input.split(" ", 2)[1]));
                break;
            case "deadline":
                String deadlineDescription = input.split(" ", 2)[1].split(" /by")[0];
                String deadline = input.split(" ", 2)[1].split(" /by")[1];
                list.addTask(new Deadline(deadlineDescription, deadline));
                break;
            case "event":
                String eventDescription = input.split(" ", 2)[1].split(" /from")[0];
                String startDate = input.split(" /from")[1].split(" /to")[0];
                String endDate = input.split(" /to ")[1];
                list.addTask(new Event(eventDescription, startDate, endDate));
                break;
            default:
                System.out.println("Please enter a valid command");
            }

            input = keyboard.nextLine();
        }
        keyboard.close();
    }

    public static void main(String[] args) {
        String greeting = """
                ____________________________________________________________
                 Hello! I'm Luke
                 What can I do for you?
                ____________________________________________________________
                """;
        System.out.println(greeting);
        List list1 = new List();

        echo(list1);

        String exitResponse = """
                ____________________________________________________________
                Bye Bye
                ____________________________________________________________
                """;
        System.out.println(exitResponse);
    }
}
