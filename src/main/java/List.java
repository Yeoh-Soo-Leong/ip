public class List {
    private final String[] tasks = new String[100];
    private int noTasks = 0;

    public void addTask(String task) {
        this.tasks[this.noTasks] = task;
        this.noTasks += 1;
        System.out.println("added: " + task);
    }

    public void listTasks() {
        for (int i = 0; i < this.noTasks; i += 1) {
            System.out.println(i + ". " + this.tasks[i]);
        }
    }
}
