package com.Vivek.OOPs.Inheritance.SingleLevel;

public class Box {
   double w, l, h;

   Box(){
       this.w = -1;
       this.l = -1;
       this.h = -1;
   }

   Box(double side) {
       this.w = side;
       this.l = side;
       this.h = side;
   }

   Box(double w, double l, double h){
       this.w = w;
       this.l = l;
       this.h = h;
   }

   Box(Box old){
       this.w = old.w;
       this.l = old.l;
       this.h = old.h;
   }
}
