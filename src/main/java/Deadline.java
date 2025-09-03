public class Deadline extends Task {
    protected String deadline;

    public Deadline(String taskDescription, String deadline) {
        super(taskDescription);
        this.deadline = deadline;
    }

    @Override
    public void printTask() {
        String checkbox = "[ ]";
        if (this.IsMarked()) {
            checkbox = "[X]";
        }
        System.out.println("[D]" + checkbox + ' ' + this.getTaskDescription() + "(by:" + this.deadline + ")");
    }
}
