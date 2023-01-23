package ua.goit.module8;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Quad quad = new Quad();
        Triangle triangle = new Triangle();
        Diamond diamond = new Diamond();
        Square square = new Square();

        PrintInfo.printShapeName(circle);
        PrintInfo.printShapeName(quad);
        PrintInfo.printShapeName(triangle);
        PrintInfo.printShapeName(diamond);
        PrintInfo.printShapeName(square);

    }
}