package unb.cs3035.individualproject;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

import static javafx.scene.paint.Color.*;

public class View extends Pane
{
    private Label header, numAssignments, numTests;;
    private HBox hBox;
    private VBox vBox;
    private Button arrowDown, arrowUp;
    private MenuBar menuBar;
    private BorderPane borderPane;
    private Menu fileMenu, viewMenu, helpMenu;
    private MenuItem aboutItem, helpItem, addEventItem, calendarViewItem, taskViewItem;
    private Scene scene;
    private Stage stage;
    private int month, year;
    private Text monthYear;
    private Rectangle leftRectangle = new Rectangle(0,0,310,1010);
    private Line line = new Line(11,311,299,311);
    private GridPane gridPane;
    private DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
    private DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("YYYY");
    private Group leftPane;

    public View()
    {
        borderPane = new BorderPane();
//        Line line = new Line(11,285,299,285);
        leftRectangle.setFill(DARKORANGE);
        line.setStroke(WHITE);
        addMenuBar();
        hBox = new HBox();
        vBox = new VBox();

        month = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();

        gridPane = drawCalender(month, year);
        leftPane = new Group (leftRectangle, line, gridPane);
        borderPane.setTop(addMenuBar());
        borderPane.setLeft(leftPane);
    }

    public Group getLeftPane()
    {
        return leftPane;
    }

    public MenuBar addMenuBar()
    {
        menuBar = new MenuBar();

        fileMenu = new Menu("File");
        viewMenu = new Menu("View");
        helpMenu = new Menu("Help");
        menuBar.getMenus().addAll(fileMenu, viewMenu, helpMenu);

        addEventItem = new MenuItem("Add Event");
        fileMenu.getItems().addAll(addEventItem);

        calendarViewItem = new MenuItem("Calendar View");
        taskViewItem = new MenuItem("Task View");
        viewMenu.getItems().addAll(calendarViewItem, taskViewItem);

        aboutItem = new MenuItem("About");
        helpItem = new MenuItem("Help");
        helpMenu.getItems().addAll(helpItem, aboutItem);

        return menuBar;
    }

    public GridPane drawCalender(int monthIn, int yearIn)
    {
        GridPane gridPane = new GridPane();

        LocalDate date = LocalDate.of(yearIn, monthIn, 1);
        int weekday = date.getDayOfWeek().getValue();
        int maxDays = date.lengthOfMonth();

        gridPane.setHgap(11);
        gridPane.setVgap(11);

        Label title = new Label(date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + yearIn);
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        title.setTextFill(WHITE);
        gridPane.add(title, 0, 0, 5, 1);
        GridPane.setHalignment(title, HPos.LEFT);

        arrowDown = new Button("▼");
        gridPane.add(arrowDown, 5, 0, 1, 1);
        GridPane.setHalignment(arrowDown, HPos.CENTER);

        arrowUp = new Button("▲");
        gridPane.add(arrowUp, 6, 0, 1, 1);
        GridPane.setHalignment(arrowUp, HPos.CENTER);

        String[] weekdays = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
        for (int i = 0; i < 7; i++) {
            header = new Label(weekdays[i]);
            header.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            header.setTextFill(WHITE);
            gridPane.add(header, i, 1);
            GridPane.setHalignment(header, HPos.CENTER);
        }
        System.out.println(weekday);
        for (int i = 1; i <= weekday; i++) {
            Label empty = new Label("");
            gridPane.add(empty, i - 1, 2);
        }

        for (int i = 1; i <= maxDays; i++)
        {
            Label day = new Label(String.valueOf(i));

            day.setStyle("-fx-font-size: 18px;");
            day.setTextFill(WHITE);
            gridPane.add(day, (i + weekday - 1) % 7, (i + weekday - 1) / 7 + 2);
            GridPane.setHalignment(day, HPos.CENTER);
        }
        gridPane.setTranslateX(30);
        gridPane.setTranslateY(25);
        return gridPane;
    }

    public Button getArrowDown()
    {
        return arrowDown;
    }

    public Button getArrowUp()
    {
        return arrowUp;
    }

    public void setYear(int newYear)
    {
        year = newYear;
    }

    public void setMonth(int newMonth)
    {
        month = newMonth;
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setLeftPane(int newMonth, int newYear)
    {
        System.out.println(newMonth + " " + newYear);
        leftPane.getChildren().remove(gridPane);
        gridPane = drawCalender(newMonth, newYear);
        leftPane = new Group (leftRectangle, line, gridPane);
        borderPane.setLeft(leftPane);
    }

    public BorderPane getBorderPane()
    {
        return borderPane;
    }
}
