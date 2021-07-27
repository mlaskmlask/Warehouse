package com.company;

public class Clothes extends Product {

    private String length;

    public Clothes(int size, String name, String color, int pieces, String length) {
        super(size, name, color, pieces);
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                super.toString()+
                "length='" + length + '\'' +
                '}';
    }
}
