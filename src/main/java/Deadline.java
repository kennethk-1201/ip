import java.time.LocalDateTime;

public class Deadline extends Task{
    private LocalDateTime deadline;

    Deadline(String content, String deadlineString) throws InvalidDateFormatException {
        super(content);
        this.deadline = DateTimeHelper.parse(deadlineString);
    }

    public boolean occursOn(LocalDateTime dt) {
        return dt.equals(this.deadline);
    }

    Deadline(String content, boolean done, String deadline) {
        super(content, done);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateTimeHelper.stringify(this.deadline) + ")";
    }
}
