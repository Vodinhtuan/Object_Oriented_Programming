
package th3;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class MangDiem 
{
    ArrayList<DiemOxy> a=new ArrayList<>();
    
    void nhapMangDiem()
    {
        int n=0;
        
        Scanner sc= new Scanner(System.in);
        do
        {
            System.out.print("nhap so diem>0: ");
            n=sc.nextInt();
        }   while(n<=0);
        
        for(int i=0;i<n;i++)
        {
            DiemOxy temp=new DiemOxy();
            System.out.print("nhap diem "+(i+1)+": ");
            temp.setX(sc.nextInt());
            temp.setY(sc.nextInt());
            a.add(temp);
        }
    }
    void xuatMangDiem(String nd)
    {
        System.out.print(nd);
        for(int i=0;i<a.size();i++)
        {
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }
    DiemOxy min()
    {
        DiemOxy min =a.get(0);
        for(int i=0;i<a.size();i++)
        {
            if(min.modul()>a.get(i).modul()) min=a.get(i);
        }
        return min;
    }
    DiemOxy max()
    {
        DiemOxy max =a.get(0);
        for(int i=0;i<a.size();i++)
        {
            if(max.modul()<a.get(i).modul()) max=a.get(i);
        }
        return max;
    }
    void input()
    {
        nhapMangDiem();
    }
    void docFile(String tenFile){
        try{
            File f = new File(tenFile);
            if(f.exists()){
                Scanner read = new Scanner(f);
                while (read.hasNext()){
                    Scanner line = new Scanner(read.nextLine());
                    // Đọc dữ liệu trên 1 dòng
                    int x = line.nextInt();
                    int y = line.nextInt();
                    a.add(new DiemOxy(x,y));
                }
            }else System.out.println("Không tồn tại file");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
    }
    void output()
    {
        xuatMangDiem("Cac diem: ");
        System.out.println("1 Diem gan tam nhat: "+min()+"="+ min().modul());
        System.out.println("2 Diem xa tam nhat: "+max()+"="+ max().modul());
        maxKhoangCach();
        tangTheoOx();
        maxTamGiac();
//        minHCN();
    }
//    void minHCN()
//    {
//        int maxX=0 ,maxY=0, minX =0, minY=0;
//        for (int i=0;i<a.size();i++)
//        {
//           if (maxX<a.get(i).getX())
//           {
//                   maxX=a.get(i).getX();
//           }
//           if (maxY<a.get(i).getY())
//           {
//                   maxY=a.get(i).getY();
//           }
//           if (minX>a.get(i).getX())
//           {
//                   minX=a.get(i).getX();
//           }
//           if (minY>a.get(i).getY())
//           {
//                   minY=a.get(i).getY();
//           }
//        } 
//        DiemOxy d1=new DiemOxy(minX,maxY);
//        DiemOxy d2=new DiemOxy(maxX,minY);
//        
//        System.out.println("5 HCN co cac canh song 2 truc chua all dime "+d1+"&"+d2);
//    }

    void maxTamGiac()
    {
        double max=0;
        DiemOxy x=a.get(0),y=a.get(1), z=a.get(2);
        for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                for (int k=j+1;k<a.size();k++)
                {
                    TamGiac temp =new TamGiac(a.get(i),a.get(j),a.get(k));
                    if(temp.laTamGiac()==true)
                    {
                        if(max<temp.dienTich())
                        {
                            max=temp.dienTich();
                            x=a.get(i);    y=a.get(j);  z=a.get(k);
                        }
                    }
                   
                }
                
            }
        }
        System.out.println("4 Tam giac co dien tich lon nhat: ("+x+","+y+","+z+")= "+max);
    }
    void tangTheoOx()
    {
        DiemOxy temp ;
        for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                if (a.get(i).getX()> a.get(j).getX())
                {
                   temp = a.get(i);
                   a.set(i,a.get(j));
                   a.set(j,temp);
               }
            }  
        }
        xuatMangDiem("6 Cac diem tang dan tren tuc Ox: "); 
    }
    void maxKhoangCach()
    {
        double max=a.get(0).khoangcach(a.get(1));
        int x=0,y=1;
        for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                if(max<a.get(i).khoangcach(a.get(j)))
                {
                    max=a.get(i).khoangcach(a.get(j));
                    x=i;    y=j;
                }
            }
        }
        System.out.println("3 Diem co khoang cach lon nhat: ("+a.get(x)+"->"+a.get(y)+")= "+max);
    }
     public static void main(String[] args) 
    {
       MangDiem a= new MangDiem();
       a.docFile("F:\\Diem.txt");
       a.output();
    }
}
