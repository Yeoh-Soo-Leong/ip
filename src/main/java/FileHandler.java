import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static final String FILENAME = "storedData.txt";

    public FileHandler(List list) {
        System.out.println("Loading stored data...");
        readFile(list);
    }

    private static void readFile(List list) {
        File file = new File(FILENAME);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + FILENAME);
                }
            } catch (IOException e) {
                System.out.println("Error opening file: " + FILENAME);
                e.printStackTrace();
            }
        }

        try (Scanner scanner = new Scanner(file)) {
            //file exists
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.loadTask(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + FILENAME);
        }
    }

    public static void addTask(Task task, boolean append) {
        // append to the back of file
        try (FileWriter fw = new FileWriter(FILENAME, append)) {
            if (task instanceof Event) {
                String newTask = "E||" + task.isMarked() + "||" + task.getTaskDescription() + "||" + ((Event) task).getStartDate() + "||" + ((Event) task).getEndDate();
                fw.write('\n' + newTask);
            } else if (task instanceof Deadline) {
                String newTask = "D||" + task.isMarked() + "||" + task.getTaskDescription() + "||" + ((Deadline) task).getDeadline();
                fw.write('\n' + newTask);
            } else if (task instanceof Todo) {
                String newTask = "T||" + task.isMarked() + "||" + task.getTaskDescription();
                fw.write('\n' + newTask);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static void updateFile(ArrayList<Task> taskList) {
        int init = 0;
        for (Task task: taskList) {
            if (init == 0) {
                addTask(task, false);
                init = 1;
            } else {
                addTask(task, true);
            }
        }
    }
}
