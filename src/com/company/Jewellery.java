package com.company;

public class Jewellery extends Product {

    private String type;

    public Jewellery(int size, String name, String color, int pieces, String type) {
        super(size, name, color, pieces);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Jewellery{" +
                super.toString()+
                "type='" + type + '\'' +
                '}';
    }
}
