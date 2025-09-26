import java.util.Scanner;

public class Luke {
    public static void echo(List list, FileHandler fileHandler) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        while (!input.equals("bye")) {
            try {
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
                    if (input.split(" ", 2).length < 2) {
                        throw new MissingTodoDescription();
                    }
                    list.addTask(new Todo(input.split(" ", 2)[1]), fileHandler);
                    break;
                case "deadline":
                    if (input.split(" ", 2).length < 2) {
                        throw new MissingDeadlineDescription();
                    } else if (input.split(" ", 2)[1].split(" /by").length < 2) {
                        throw new MissingDeadlineByWhen();
                    }
                    String deadlineDescription = input.split(" ", 2)[1].split(" /by")[0];
                    String deadline = input.split(" ", 2)[1].split(" /by")[1];
                    list.addTask(new Deadline(deadlineDescription, deadline), fileHandler);
                    break;
                case "event":
                    if (input.split(" ", 2).length < 2) {
                        throw new MissingEventDescription();
                    } else if (input.split(" /from").length < 2) {
                        throw new MissingEventFromWhen();
                    } else if (input.split(" /to").length < 2) {
                        throw new MissingEventToWhen();
                    }
                    String eventDescription = input.split(" ", 2)[1].split(" /from")[0];
                    String startDate = input.split(" /from")[1].split(" /to")[0];
                    String endDate = input.split(" /to ")[1];
                    list.addTask(new Event(eventDescription, startDate, endDate), fileHandler);
                    break;
                case "delete":
                    if (input.split(" ", 2).length < 2) {
                        throw new MissingDeleteIndex();
                    }
                    list.removeTask(Integer.parseInt(input.split(" ", 2)[1]) - 1, fileHandler);
                    break;
                default:
                    System.out.println("Please enter a valid command");
                }
            } catch (MissingTodoDescription e) {
                System.err.println("Todo cannot be empty");
            } catch (MissingDeadlineDescription e) {
                System.err.println("Deadline description is missing");
            } catch (MissingDeadlineByWhen e) {
                System.err.println("Deadline by when is missing");
            } catch (MissingEventDescription e) {
                System.err.println("Event description is missing");
            } catch (MissingEventFromWhen e) {
                System.err.println("Event from when is missing");
            } catch (MissingEventToWhen e) {
                System.err.println("Event to when is missing");
            } catch (MissingDeleteIndex e) {
                System.err.println("Delete index missing");
            } catch (Exception e) {
                System.err.println("Please enter a valid command");
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
        FileHandler fileHandler = new FileHandler(list1);

        echo(list1, fileHandler);

        String exitResponse = """
                ____________________________________________________________
                Bye Bye
                ____________________________________________________________
                """;
        System.out.println(exitResponse);
    }
}
