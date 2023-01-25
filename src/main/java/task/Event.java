package task;

import helper.DateTimeHelper;

import exception.InvalidDateFormatException;

import java.time.LocalDateTime;

public class Event extends Task{
    private LocalDateTime start;
    private LocalDateTime end;

    Event(String content, String startString, String endString) throws InvalidDateFormatException {
        super(content);
        this.start = DateTimeHelper.parse(startString);
        this.end = DateTimeHelper.parse(endString);
    }

    public boolean occursOn(LocalDateTime datetime) {
        return datetime.equals(this.start)
                || (datetime.isAfter(this.start) && datetime.isBefore(this.end))
                || datetime.equals(this.end);
    }

    Event(String content, boolean done, String startString, String endString) throws InvalidDateFormatException {
        super(content, done);
        this.start = DateTimeHelper.parseFormattedDateTime(startString);
        this.end = DateTimeHelper.parseFormattedDateTime(endString);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: " + DateTimeHelper.stringify(this.start)
                + " to: " + DateTimeHelper.stringify(this.end) + ")";
    }
}
