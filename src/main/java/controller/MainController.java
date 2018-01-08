package controller;

import model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.HashMap;

public class MainController {

    @FXML private TableView<Task> tasks;

    @FXML private DatePicker datePicker;

    @FXML private TaskController taskController;

    private HashMap<String, TableView<Task>> currentDayTasks;

    @FXML private void initialize() {
        this.taskController.injectMainController(this);
    }

    public MainController() {
        this.currentDayTasks = new HashMap<>();
        this.taskController = new TaskController();
    }

    public void changeDate() {

    }

    @FXML
    private void createNewTask() throws IOException {
        this.taskController.showAddForm();
    }

    public HashMap<String, TableView<Task>> getCurrentDayTasks() {
        return currentDayTasks;
    }

    public void setCurrentDayTasks(HashMap<String, TableView<Task>> currentDayTasks) {
        this.currentDayTasks = currentDayTasks;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

}
