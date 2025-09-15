public class List {
    private final Task[] tasks = new Task[100];
    private int noTasks = 0;

    public void addTask(Task task) {
        this.tasks[this.noTasks] = task;
        this.noTasks += 1;
        System.out.println("added: " + task.getTaskDescription());
    }

    public void removeTask(int index) {
        System.out.println("removed: " + tasks[index].getTaskDescription());
        this.tasks[index] = null;
        for (int j = index; j < this.noTasks; j++)
            this.tasks[j] = this.tasks[j + 1];
        this.noTasks -= 1;
    }

    public void listTasks() {
        for (int i = 0; i < this.noTasks; i += 1) {
            System.out.print((i + 1) + ".");
            this.tasks[i].printTask();
        }
    }

    public void markTaskAsDone(int id) {
        this.tasks[id].setIsMarked(true);
        System.out.println("marked task " + this.tasks[id].getTaskDescription() + " as done");
    }

    public void markTaskAsNotDone(int id) {
        this.tasks[id].setIsMarked(false);
        System.out.println("marked task " + this.tasks[id].getTaskDescription() + " as not done");
    }
}
