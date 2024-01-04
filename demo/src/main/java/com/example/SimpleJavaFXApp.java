package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Shapes.Coords;
import com.example.Shapes.Oval;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SimpleJavaFXApp extends Application {
    final int s = 800;
    public List<Coords> red = new ArrayList<>();
    public List<Coords> green = new ArrayList<>();
    public List<Coords> line = new ArrayList<>();
    Pane root;

    @Override
    public void start(Stage stage) {
        root = new Pane();
        initUI(stage);
    }

    private void draw_line(){
        Model k = new Model(red, green);
        List<Coords> t = k.get();
        int i = 0;
        line = t;
        // for (int a : t) {
        //     System.out.println(a);
        //     line.add(new Coords(800/s*i, 800/s*a));
        //     i++;
        // }
    }

    private void create_oval(double x, double y, boolean t){
        Oval s = new Oval(x, y, t);
        root.getChildren().add(s);
        if (t){
            green.add(s.getCoords());
            // line.add(s.getCoords());
        }
        else red.add(s.getCoords());
    }

    private void initUI(Stage stage) {
        var canvas = new Canvas(800, 800);
        var scene = new Scene(root, 800, 800, Color.WHITESMOKE);
        Circle s = new Oval(10, 10, true);

        var gc = canvas.getGraphicsContext2D();
        scene.setOnMouseClicked(event->{
            if (event.getButton() == MouseButton.PRIMARY){
                create_oval(event.getSceneX(), event.getSceneY(), true);
            }
            else if (event.getButton() == MouseButton.SECONDARY)
            {
                create_oval(event.getSceneX(), event.getSceneY(), false);
            }
        });

        // Circle k = new Circle(100, 50, 100);
        // Circle s = new Oval(100, 100, true);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                draw_line();
                drawLines(gc);
            } 
        }; 

        Button b = new Button("button"); 
        b.setOnAction(event); 
        root.getChildren().add(s);
        root.getChildren().add(canvas);
        root.getChildren().add(b);

        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();
        
    }

    

    private void drawLines(GraphicsContext gc) {

        gc.beginPath();
        gc.moveTo(0, 800);
        for (Coords coords : line) {
            gc.lineTo(coords.x, coords.y);
        }
        gc.stroke();
    }

    public static void main(String[] args) {
        launch(args);
    }
}