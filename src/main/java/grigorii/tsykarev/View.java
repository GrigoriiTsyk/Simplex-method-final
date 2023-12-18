package grigorii.tsykarev;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View {
    public Parent createElements() {
        Label label1 = new Label("Set rows");
        Label label2 = new Label("Set columns");

        ObservableList<Integer> scaleValues = FXCollections.observableArrayList();

        for (int i = 1; i <= 16; i++) {
            scaleValues.add(i);
        }

        ChoiceBox cbRows = new ChoiceBox(scaleValues);
        ChoiceBox cbCols = new ChoiceBox(scaleValues);
        cbRows.setValue(1);
        cbCols.setValue(1);

        Button button = new Button("Set");

        Group group = new Group(button);

        GridPane matrix = createMaitrix(Integer.parseInt(cbRows.getValue().toString()),
                                        Integer.parseInt(cbCols.getValue().toString()));

        HBox scaleHBox = new HBox(label1, cbRows, label2, cbCols, group);

        Label answer = new Label("Answer: ");

        VBox vbox = new VBox(scaleHBox, matrix, answer);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int rows = Integer.parseInt(cbRows.getValue().toString());
                int cols = Integer.parseInt(cbCols.getValue().toString());

                System.out.println("rows = " + rows + " cols = " + cols);

                GridPane newMatrix = createMaitrix(rows, cols);

                vbox.getChildren().set(vbox.getChildren().size() - 2, newMatrix);
            }
        });

        FlowPane root = new FlowPane(vbox);

        return root;
    }

    private GridPane createMaitrix(int rows, int cols) {
        GridPane matrix = new GridPane();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TextField tf = new TextField();
                tf.setPrefHeight(20);
                tf.setPrefWidth(70);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(true);
                tf.setText("0");

                matrix.setRowIndex(tf, i);
                matrix.setColumnIndex(tf, j);
                matrix.getChildren().add(tf);
            }
        }

        return matrix;
    }
}
