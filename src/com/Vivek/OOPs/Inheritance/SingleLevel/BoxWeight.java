package com.Vivek.OOPs.Inheritance.SingleLevel;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight(){
        //super() calls constructor of the parent class.
        super();
        this.weight = -1;
    }

    BoxWeight(double l, double h, double w, double weight){
        super(l, h, w);
        this.weight = weight;
    }
}
