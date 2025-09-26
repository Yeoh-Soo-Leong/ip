public class Task {
    private String taskDescription;
    private boolean isMarked;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isMarked = false;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setIsMarked(boolean marked) {
        this.isMarked = marked;
    }

    public void printTask() {
        String checkbox = "[ ]";
        if (this.isMarked()) {
            checkbox = "[X]";
        }
        System.out.print(checkbox + ' ' + this.taskDescription);
    }
}
