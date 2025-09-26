import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    private static final String FILENAME = "storedData.txt";

    public FileHandler(List list) {
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
                String[] lineArray = line.split("||");
                // check todo, deadline, event
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + FILENAME);
        }
    }

    public void addTask(Task task) {
        // append to the back of file
        try (FileWriter fw = new FileWriter(FILENAME, true)) {
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

//    public static void updateFile(List taskList) {
//        for (Task task: taskList) {
//            addTask(task);
//        }
//    }
}
