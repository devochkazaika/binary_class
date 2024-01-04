package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Shapes.Coords;
import com.example.Shapes.Oval;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SimpleJavaFXApp extends Application {

    public List<Coords> red = new ArrayList<>();
    public List<Coords> green = new ArrayList<>();
    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void create_oval(Pane root, double x, double y, boolean t){
        Oval s = new Oval(x, y, t);
        root.getChildren().add(s);
        if (t) green.add(s.getCoords());
        else red.add(s.getCoords());
    }

    private void initUI(Stage stage) {
        var root = new Pane();
        var canvas = new Canvas(800, 800);
        var scene = new Scene(root, 800, 800, Color.WHITESMOKE);
        Circle s = new Oval(10, 10, true);
        scene.setOnMouseClicked(event->{
            if (event.getButton() == MouseButton.PRIMARY){
                create_oval(root, event.getSceneX(), event.getSceneY(), true);
            }
            else if (event.getButton() == MouseButton.SECONDARY)
            {
                create_oval(root, event.getSceneX(), event.getSceneY(), false);
            }
        });

        // Circle k = new Circle(100, 50, 100);
        // Circle s = new Oval(100, 100, true);
        root.getChildren().add(s);
        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();
        
    }

    

    private void drawLines(GraphicsContext gc) {

        gc.beginPath();
        gc.moveTo(30.5, 30.5);
        gc.lineTo(150.5, 30.5);
        gc.lineTo(150.5, 150.5);
        gc.lineTo(30.5, 30.5);
        gc.stroke();
    }

    public static void main(String[] args) {
        launch(args);
    }
}