package com.google.lesson_04;

public class Circle extends Shape {
    private double radius;

    public Circle(String borderColor, String backgroundColor, double radius) {
        super(borderColor, backgroundColor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "radius: " + radius + " backgroundColor: " + getBackgroundColor();
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
