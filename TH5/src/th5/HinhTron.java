
package th5;

public class HinhTron 
{
    private DiemOxy tam;
    private double bankinh;

    public HinhTron() {
    }

    public HinhTron(DiemOxy tam, double bankinh) {
        this.tam = tam;
        this.bankinh = bankinh;
    }

    public DiemOxy getTam() {
        return tam;
    }

    public double getBankinh() {
        return bankinh;
    }

    public void setTam(DiemOxy tam) {
        this.tam = tam;
    }

    public void setBankinh(double bankinh) {
        this.bankinh = bankinh;
    }

    @Override
    public String toString() {
        return "tam" + tam + ", ban kinh=" + bankinh + '}';
    }
    double chuvi()
    {
        return 2*bankinh*Math.PI;
    }
    double dientich()
    {
        return bankinh*bankinh*Math.PI;
    }
}
