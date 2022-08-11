
package th11;

public class CNTT extends SinhVien implements IXepLoai {
    private int java, css, html;

    public CNTT() {
    }

    public CNTT(String ma, String ht, boolean gt,int java, int css, int html) {
        super(ma, ht, gt);
        this.java = java;
        this.css = css;
        this.html = html;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getCss() {
        return css;
    }

    public void setCss(int css) {
        this.css = css;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }
    @Override
    public double diemtrungbinh()
    {
        return (java*2+css+html)/4.0;
    }

    @Override
    public String getHocluc()
    {
        double dtb=diemtrungbinh();
        if(dtb>=9) return "xuat sac";
        if(dtb>=8) return "gioi";
        if(dtb>=6.5) return "kha";
        if(dtb>=5) return "truung binh";
        if(dtb>=3) return "yeu";
        return "kem";
    }

    @Override
    public String toString() {
        return super.toString()+getHocluc();
    }
}
