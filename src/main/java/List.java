public class List {
    private final Task[] tasks = new Task[100];
    private int noTasks = 0;

    public void addTask(String task) {
        this.tasks[this.noTasks] = new Task(task);
        this.noTasks += 1;
        System.out.println("added: " + task);
    }

    public void listTasks() {
        for (int i = 0; i < this.noTasks; i += 1) {
            System.out.println(i + ". " + this.tasks[i].getTaskDescription());
        }
    }

    public void markTaskAsDone(int id) {
        this.tasks[id].setIsMarked(true);
    }

    public void markTaskAsNotDone(int id) {
        this.tasks[id].setIsMarked(false);
    }
}
