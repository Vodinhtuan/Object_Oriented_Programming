
package th6;

public class Cylinder extends Circle {
    private double height;
    
    public Cylinder(){
        super();
        height = 0;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }
    
    public double getArea(){
        return getCircum()*height + 2*super.getArea();
    }
    
    public double getVolume(){
        return super.getArea()*height;
    }

    public String toString() {
        return "Cylinder "+ radius + " " +height + ' ' +getArea();
    }

    public static void main(String[] args) {
       
    }
}
