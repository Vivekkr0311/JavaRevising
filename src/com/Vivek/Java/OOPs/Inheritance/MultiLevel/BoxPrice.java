package com.Vivek.Java.OOPs.Inheritance.MultiLevel;

public class BoxPrice extends BoxWeight {
    double cost;

    BoxPrice(){
        super();
        this.cost = -1;
    }

//    BoxPrice(BoxPrice old){
//        super(old); This should work, but showing an error.
//        this.cost = old.cost;
//    }
    BoxPrice(double l, double h, double w, double weight, double cost){
        super(l, h, w, weight);
        this.cost = cost;
    }
}
