package kfu.itis.maslennikov.net.fx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class JavaFxApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene main = new Scene(root,600,600);
        stage.setScene(main);

        Line line = new Line();
        line.setStartX(0);
        line.setStartY(0);
        line.setEndX(200);
        line.setEndY(200);

        Text text = new Text();
        text.setText("Hello World");
        text.setX(300);
        text.setY(300);

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Hello World");
        GridPane gridPane = new GridPane();
        ButtonType connect = new ButtonType("Connect", ButtonBar.ButtonData.OK_DONE);
        TextField username  = new TextField();
        username.setPromptText("Username");
        gridPane.add(username, 1, 0);

        dialog.getDialogPane().getButtonTypes().addAll(connect);
        dialog.getDialogPane().setContent(gridPane);

        dialog.setResultConverter(button -> {
            if (connect.equals(button)) {
                return username.getText();
            }
            return null;
        });

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(System.out::println);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ахтунг!");
        alert.setContentText("Ты " + result.orElse(""));
        Button click = new Button("Ичо");
        click.setOnAction(event -> alert.show());

        ObservableList children = root.getChildren();

        children.addAll(line, text, click);

        stage.show();

        KeyCombination kc = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
        main.setOnKeyPressed(event -> {
            if (kc.match(event)) {
                System.out.println("key comb pressed");
            }
            switch (event.getCode()) {
                case A -> alert.show();
                case Q -> stage.close();
            }
        });
    }
}
