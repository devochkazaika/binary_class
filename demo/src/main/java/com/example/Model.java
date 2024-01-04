package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Shapes.Coords;

public class Model {
    final int s = 100;
    double[][] w = new double[s][s];
    public Model(List<Coords> red, List<Coords> green){
        double w1;
        double w2;
        for (int i=0; i<s; i++){
            for (int j=0; j<s; j++){
                w1 = 0;
                w2 = 0;
                for (Coords coords : green) {
                    w1 = w1 + Math.pow((800/s*i-coords.x), 2) + Math.pow((800/s*j-coords.y), 2);
                }
                for (Coords coords : red) {
                    w2 = w2 + Math.pow((800/s*i-coords.x), 2) + Math.pow((800/s*j-coords.y), 2);
                }
                w1 = w1 / green.size();
                w2 = w2 / red.size();
                w[i][j] = w1 / (w1+w2);
            }
        }
    }
    public List<Coords> get(){
        List<Coords> k = new ArrayList<>();
        for (int i=0; i<s; i++){
            for (int j=0; j<s; j++){
                if (Math.pow(0.5-w[i][j], 2) < 0.001){
                    k.add(new Coords(800/s*i, 800/s*j));
                }
            }
        }
        return k;
    }
}
