import java.util.ArrayList;

public class List {
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
            tasks.add(new Deadline(lineArray[2], lineArray[3]));
            System.out.println("added: " + lineArray[2]);
            if (lineArray[1].equals("true")) {
                markTaskAsDone(tasks.size() - 1);
            }
        } else if  (lineArray[0].equals("E")) {
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
