import java.util.Scanner;

public class Luke {
    public static void echo(List list) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                list.listTasks();
            } else {
                list.addTask(input);
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
