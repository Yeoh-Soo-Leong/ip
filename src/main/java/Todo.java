public class Todo extends Task {
    public Todo(String taskDescription) {
        super(taskDescription);
    }

    @Override
    public void printTask() {
        String checkbox = "[ ]";
        if (this.IsMarked()) {
            checkbox = "[X]";
        }
        System.out.println("[T]" + checkbox + ' ' + this.getTaskDescription());
    }
}
