import java.util.Scanner;

public class Luke {
    public static void echo() {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        while (!input.equals("bye")) {
            String response = "____________________________________________________________\n" +
                    input + "\n" +
                    "____________________________________________________________\n";
            System.out.println(response);
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

        echo();

        String exitResponse = """
                ____________________________________________________________
                Bye Bye
                ____________________________________________________________
                """;
        System.out.println(exitResponse);
    }
}
