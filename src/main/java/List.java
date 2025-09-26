import java.util.ArrayList;

public class List {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("added: " + task.getTaskDescription());
    }

    public void removeTask(int index) {
        System.out.println("removed: " + tasks.get(index).getTaskDescription());
        tasks.remove(index);
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i += 1) {
            System.out.print((i + 1) + ".");
            tasks.get(i).printTask();
        }
    }

    public void markTaskAsDone(int id) {
        tasks.get(id).setIsMarked(true);
        System.out.println("marked task " + tasks.get(id).getTaskDescription() + " as done");
    }

    public void markTaskAsNotDone(int id) {
        tasks.get(id).setIsMarked(false);
        System.out.println("marked task " + tasks.get(id).getTaskDescription() + " as not done");
    }
}
