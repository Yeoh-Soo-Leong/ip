import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task, FileHandler fileHandler) {
        tasks.add(task);
        System.out.println("added: " + task.getTaskDescription());
        FileHandler.addTask(task, true);
    }

    public void removeTask(int index, FileHandler fileHandler) {
        System.out.println("removed: " + tasks.get(index).getTaskDescription());
        tasks.remove(index);
        FileHandler.updateFile(tasks);
    }

    public void loadTask(String line) {
        String[] lineArray = line.split("\\|\\|");
        if (lineArray[0].equals("T")) {
            tasks.add(new Todo(lineArray[2]));
            System.out.println("added: " + lineArray[2]);
            if (lineArray[1].equals("true")) {
                markTaskAsDone(tasks.size() - 1);
            }
        } else if (lineArray[0].equals("D")) {
            try {
                LocalDate deadline = LocalDate.parse(lineArray[3]);
                tasks.add(new Deadline(lineArray[2], deadline));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid deadline format, please enter in a yyyy-mm-dd format");
            }
            System.out.println("added: " + lineArray[2]);
            if (lineArray[1].equals("true")) {
                markTaskAsDone(tasks.size() - 1);
            }
        } else if (lineArray[0].equals("E")) {
            tasks.add(new Event(lineArray[2], lineArray[3], lineArray[4]));
            System.out.println("added: " + lineArray[2]);
            if (lineArray[1].equals("true")) {
                markTaskAsDone(tasks.size() - 1);
            }
        } else {
            System.out.println("Invalid line format");
        }
    }

    public void listTasks() {
        // prints all tasks in the list
        for (int i = 0; i < tasks.size(); i += 1) {
            System.out.print((i + 1) + ".");
            tasks.get(i).printTask();
        }
    }

    public void findTask(String string) {
        int j = 1;
        for (Task task : tasks) {
            if (task.getTaskDescription().contains(string)) {
                System.out.print(j + ".");
                task.printTask();
                j++;
            }
        }
    }

    public void markTaskAsDone(int id) {
        tasks.get(id).setIsMarked(true);
        System.out.println("marked task " + tasks.get(id).getTaskDescription() + " as done");
        FileHandler.updateFile(tasks);
    }

    public void markTaskAsNotDone(int id) {
        tasks.get(id).setIsMarked(false);
        System.out.println("marked task " + tasks.get(id).getTaskDescription() + " as not done");
        FileHandler.updateFile(tasks);
    }
}
