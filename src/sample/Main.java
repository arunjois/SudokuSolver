package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane board = new GridPane();
        board.setId("board");
        board.setPadding(new Insets(20));
        TextField[][] field = new TextField[9][9];
        Button ok = new Button("Done");
        Button check = new Button("Solve");
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++) {
                field[j][i] = new TextField();
                board.add(field[j][i], j, i);
                field[j][i].setId("field");
            }
        }
        board.add(check,30,6);
        System.out.println(field.length+" "+field[0].length);
        board.setHgap(5);
        board.setVgap(5);

        check.setOnAction(e->solve(field));

        Scene myScene = new Scene(board,800,500);
        myScene.getStylesheets().add(getClass().getResource("./sudoku.css").toExternalForm());


        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    public void solve(TextField[][] grid) {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                System.out.println(grid[j][i]);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
