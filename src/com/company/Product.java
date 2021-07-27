package com.company;

public class Product {

    private int size;
    private String name;
    private String color;
    private int pieces;

    public Product(int size, String name, String color, int pieces) {
        this.size = size;
        this.name = name;
        this.color = color;
        this.pieces = pieces;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "size=" + size +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", pieces=" + pieces +", ";
    }
}
