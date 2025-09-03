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
            System.out.print((i + 1) + ".");
            this.tasks[i].printTask();
        }
    }

    public void markTaskAsDone(int id) {
        this.tasks[id].setIsMarked(true);
        System.out.println("marked task " + this.tasks[id].getTaskDescription() + 1 + " as done");
    }

    public void markTaskAsNotDone(int id) {
        this.tasks[id].setIsMarked(false);
        System.out.println("marked task " + this.tasks[id].getTaskDescription() + 1 + " as not done");
    }
}
