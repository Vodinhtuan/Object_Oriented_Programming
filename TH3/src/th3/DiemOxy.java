
package th3;

public class DiemOxy 
{
    private int x,y;

    public DiemOxy() 
    {
    }

    public DiemOxy(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x + ","+y+")";
    }
    
    double modul()
    {
        return Math.sqrt(Math.pow(0-x, 2)+Math.pow(0-y, 2));
    }
    double khoangcach(DiemOxy a)
    {
        return Math.sqrt(Math.pow(a.x-x, 2)+Math.pow(a.y-y, 2));
    }
    public static void main(String[] args) 
    {
       
    }
    
}
