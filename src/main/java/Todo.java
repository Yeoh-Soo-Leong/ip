public class Todo extends Task {
    public Todo(String taskDescription) {
        super(taskDescription);
    }

    @Override
    public void printTask() {
        System.out.print("[T]");
        super.printTask();
        System.out.println();
    }
}
