public class Event extends Task{
    protected String startDate;
    protected String endDate;

    public Event(String taskDescription, String startDate, String endDate) {
        super(taskDescription);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public void printTask() {
        String checkbox = "[ ]";
        if (this.IsMarked()) {
            checkbox = "[X]";
        }
        System.out.println("[E]" + checkbox + ' ' + this.getTaskDescription() + " (from:" + this.startDate + " to " + this.endDate + ")");
    }
}
