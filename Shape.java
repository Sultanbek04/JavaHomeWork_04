package com.google.lesson_04;

public abstract class Shape {
    private String borderColor;
    private String backgroundColor;

    public Shape(String borderColor, String backgroundColor) {
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        return "oop.Shape{" +
                "borderColor='" + borderColor + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                '}';
    }

    public abstract double calcArea();
}
