package ua.goit.module8;

public class Shape {
    private String name;

    public Shape (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
         return "name: " + name;
    }
}
