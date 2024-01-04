package com.example.Shapes;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Oval extends Circle{
    public Circle circle;
    private double x;
    private double y;
    private boolean t;
    Coords coord;
    public Oval(double a, double b, boolean col){
        super(a, b, 3);
        circle = new Circle(a, b, 5);
        coord = new Coords(a, b);
        if (col) setFill(Paint.valueOf("green"));
        else setFill(Paint.valueOf("red"));
        x = a; y=b;
        t = col;
    }

    public Coords getCoords(){
        return coord;
    }
    

}