/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th6;

public class Circle {
    protected double radius;

    public Circle() {
        
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    public double getArea(){
        return radius*radius*Math.PI;
    }
    
    public double getCircum(){
        return 2*radius*Math.PI;
    }

    public String toString() {
        return "Circle " + radius + ' ' + getArea();
    }
    

    public static void main(String[] args) {
       
    }
    
}