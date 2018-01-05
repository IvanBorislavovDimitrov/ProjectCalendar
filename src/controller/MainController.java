package controller;

import model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.HashMap;

public class MainController {

    @FXML
    private DatePicker datePicker;

    private HashMap<String, TableView<Task>> currentDayTasks;

    private TaskController taskController;

    public MainController() {
        this.currentDayTasks = new HashMap<>();
        this.taskController = new TaskController(this.datePicker, this.currentDayTasks);
    }

    public void changeDate() {

    }

    @FXML
    private void createNewTask() throws IOException {
        this.taskController.setDatePicker(this.datePicker);
        this.taskController.showAddForm();

    }

    public HashMap<String, TableView<Task>> getCurrentDayTasks() {
        return currentDayTasks;
    }

    public void setCurrentDayTasks(HashMap<String, TableView<Task>> currentDayTasks) {
        this.currentDayTasks = currentDayTasks;
    }
}
