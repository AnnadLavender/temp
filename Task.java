package unb.cs3035.individualproject;

import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class Task
{
    private String title, courseId, type, location, status;
    private LocalDate dateBegin, dateEnd;
    private String timeBegin, timeEnd;
    private int taskId = 0;

    public Task(String titleIn, String courseIdIn, String typeIn, String locationIn, DatePicker dateBeginIn, String timeBeginIn, DatePicker dateEndIn, String timeEndIn)
    {
        this.title = titleIn;
        this.courseId = courseIdIn;
        this.type = typeIn;
        this.location = locationIn;
        this.dateBegin = dateBeginIn.getValue();
        this.timeBegin = timeBeginIn;
        this.dateEnd = dateEndIn.getValue();
        this.timeEnd = timeEndIn;
        this.status = "Unfinished";
        taskId += 1;
    }

    public String getType()
    {
        return type;
    }

    public String getStatus()
    {
        return status;
    }
}
