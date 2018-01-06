package controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import model.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TaskController {

    @FXML
    private TextField hourField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField locationField;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;

    private Stage window;

    private MainController mainController;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public TaskController() { }

    public void showAddForm() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/addView.fxml"));

        this.window = new Stage();
        this.window.setTitle("Create task");

        this.window.setScene(new Scene(root));
        this.window.show();
    }

    @FXML
    private void addTask() { // properties become null, default constructor is invoked, why?
        String description = this.descriptionField.getText();
        String hour = this.hourField.getText();
        String location = this.locationField.getText();
        Task task = new Task();
        task.setHour(hour);
        task.setDescription(description);
        task.setLocation(location);

        HashMap<String, TableView<Task>> currentDayTasks = this.mainController.getCurrentDayTasks();
        DatePicker datePicker = this.mainController.getDatePicker();

        String currentDate = datePicker.getValue().toString();

        if (!currentDayTasks.containsKey(currentDate)) { // null pointer exception
            currentDayTasks.put(datePicker.getValue().toString(), new TableView<>());
            currentDayTasks.get(datePicker.getValue().toString()).getItems().add(task);
        } else {
            currentDayTasks.get(datePicker.getValue().toString()).getItems().add(task);
        }
        this.window.close();
    }

    public void cancelAdding() {
        this.window.close();
    }

}
