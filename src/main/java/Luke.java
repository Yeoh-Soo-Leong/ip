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
