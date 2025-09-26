public class Deadline extends Task {
    protected String deadline;

    public Deadline(String taskDescription, String deadline) {
        super(taskDescription);
        this.deadline = deadline;
    }

    @Override
    public void printTask() {
        System.out.print("[D]");
        super.printTask();
        System.out.println(" (by:" + this.deadline + ")");
    }

    public String getDeadline() {
        return deadline;
    }
}
