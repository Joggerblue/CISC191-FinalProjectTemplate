package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameBoard extends Application implements EventHandler<ActionEvent>{

    private Stage primary;
    private Scene scene;
    private GridPane pane;
    private GameButton [] buttons;
    private final int MAXUTTONS = 9;


    public static void main(String[]args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primary = primaryStage;
        // new pane
        pane = new GridPane();
        //new scene, add pane to scene
        scene = new Scene(pane, 300, 300);

        // buttons
        buttons = new GameButton[MAXUTTONS];
        for(int i=0; i<MAXUTTONS; ++i){
            buttons[i] = new GameButton();
            buttons[i].setPrefSize(100,100);
            buttons[i].setOnAction(this);
        }
        int buttonIndex = 0;
        for (int rowIndex=0; rowIndex<3; ++rowIndex){
            for (int columnIndex=0; columnIndex<3; ++columnIndex){
                pane.add(buttons[buttonIndex], columnIndex, rowIndex);
                ++buttonIndex;
            }
        }


        primary.setTitle("Button Demo");
        primary.setScene(scene);
        primary.show();
    }


    @Override
    public void handle(ActionEvent event) {
        for(int i=0; i<MAXUTTONS; ++i){
            if (buttons[i]==event.getSource()){
                try {
                    buttons[i].changeState();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }}