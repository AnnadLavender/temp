package unb.cs3035.individualproject;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.util.ArrayList;

public class Model
{
    private SimpleListProperty<Task> taskList;
    public Model()
    {
        ArrayList<Task> list = new ArrayList<>();
        ObservableList<Task> observableList = (ObservableList<Task>) FXCollections.observableArrayList(list);
        taskList = new SimpleListProperty<Task>(observableList);
    }

    public void addAssignment(String titleIn, String courseIdIn, DatePicker dateBeginIn, String timeBeginIn, DatePicker dateEndIn, String timeEndIn)
    {
        Task assignment = new Task(titleIn, courseIdIn, "Assignment", "", dateBeginIn, timeBeginIn, dateEndIn, timeEndIn);
        taskList.add(assignment);
    }

    public void addTest(String titleIn, String courseIdIn, String locationIn, DatePicker dateBeginIn, String timeBeginIn, String timeEndIn)
    {
        Task test = new Task(titleIn, courseIdIn, "Test", locationIn, dateBeginIn, timeBeginIn, dateBeginIn, timeEndIn);
        taskList.add(test);
    }

    public void addTask(Task task)
    {
        taskList.add(task);
    }

    public void deleteTask(Task task)
    {
        taskList.remove(task);
    }

    public int countUnfinishedTask(String typeIn)
    {
        int count = 0;
        for(Task task : taskList)
        {
            if(task.getType().equals(typeIn) && task.getStatus().equals("Unfinished"))
            {
                count++;
            }
        }
        return count;
    }
}
