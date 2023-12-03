package unb.cs3035.individualproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller
{
    public enum State {READY, DRAG_SELECTION_STARTED, DRAG_ITEMS_STARTED}
    private State state;

    public Controller()
    {
        Main.view.getArrowDown().setOnAction(new arrowDownHandler());
        Main.view.getArrowUp().setOnAction(new arrowUpHandler());
        Main.view.addEventHandler(MouseEvent.ANY, new MouseHandler());
        state = State.READY;
    }

    public class MouseHandler implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            switch(state)
            {
                case READY:
                    if(mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED)
                    {
                        System.out.println();
                    }
                    else if(mouseEvent.getEventType() == MouseEvent.DRAG_DETECTED)
                    {
                    }
                    else if(mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED)
                    {
                        Main.view.getArrowDown().setOnAction(new arrowDownHandler());
                        Main.view.getArrowUp().setOnAction(new arrowUpHandler());
                    }
                    break;

                case DRAG_ITEMS_STARTED:
                    break;

                case DRAG_SELECTION_STARTED:
                    break;
            }
        }
    }

    public class arrowDownHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            int currentMonth = Main.view.getMonth();
            if(currentMonth <= 12 && currentMonth >= 2)
            {
                Main.view.setMonth(currentMonth - 1);
            }
            else if(currentMonth == 1)
            {
                Main.view.setMonth(12);
                Main.view.setYear(Main.view.getYear() - 1);
            }
            Main.view.setLeftPane(Main.view.getMonth(), Main.view.getYear());
        }
    }

    public class arrowUpHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            int currentMonth = Main.view.getMonth();
            if(currentMonth <= 11 && currentMonth >= 1)
            {
                Main.view.setMonth(currentMonth + 1);
            }
            else if(currentMonth == 12)
            {
                Main.view.setMonth(1);
                Main.view.setYear(Main.view.getYear() + 1);
            }
            Main.view.setLeftPane(Main.view.getMonth(), Main.view.getYear());
        }
    }
}
