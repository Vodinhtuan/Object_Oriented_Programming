package cs311c;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Mang3{
    ArrayList<Integer> a = new ArrayList<>();
    void input(){
        int n;
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter number: ");
        do {n = kb.nextInt();
            if (n<=0) System.out.print("Re-enter number: ");
        } while (n<=0);
        for (int i=0;i<n;i++)
            a.add((int)(Math.random()*100));//a[i] = (int)(Math.random()*100);
    }
    
    void out(String nd){
        System.out.print(nd);
        for (int i=0;i<a.size();i++)
            System.out.print(a.get(i)+ " ");
        System.out.println();
    }
    
    boolean checkPrime(int x){
        if (x<2) return false;
        else{
            for (int i=2;i<=Math.sqrt(x);i++)
                if (x%i==0) return false;
            return true;       
        }
    }
    
    boolean checkSym(int x){
        int x1 = Math.abs(x), temp = 0;
        if (x1 < 10) return false;
        else{
            while (x1>0){
            temp = temp*10+x1%10;
            x1 = x1/10;
            }
            if (temp == x) return true;
        }
        return false;
    }
    
    void insert(){
        int x, k;
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter number to insert: ");
        x = kb.nextInt();
        System.out.print("Enter location to insert: ");
        do {k = kb.nextInt();
            if (k < 1 || k > a.size()) System.out.print("Re-enter location: ");
        } while (k < 1 || k > a.size());
        a.add(k, x);
    }
    
    void delete(){
        int k;
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter location to delete: ");
        do {k = kb.nextInt();
            if (k < 1 || k > a.size()) System.out.print("Re-enter location: ");
        } while (k < 1 || k > a.size());
        a.remove(k);
    }
    
    /*void sort(){
       int temp;
       for (int i=0;i<n;i++)
           for (int j=i+1;j<n;j++)
               if (a[i]>a[j]){
                   temp = a[i];
                   a[i] = a[j];
                   a[j] = temp;
               }
    }*/
    
    void output(){
        out(a.size() + " medium create: ");
        
        System.out.print("The prime numbers: ");
        for (int i=0;i<a.size();i++)
            if (checkPrime(a.get(i)) == true) System.out.print(a.get(i) + " ");
        System.out.print("\nSymmetrical numbers: ");
        for (int i=0;i<a.size();i++)
            if (checkSym(a.get(i)) == true) System.out.print(a.get(i) + " ");
        System.out.println();
        insert();
        out("Array after insert: ");
        delete();
        out("Array after delete: ");
        Collections.sort(a);
        out("Array after sort: ");
    }
    public static void main(String[] args) {
        Mang3 a = new Mang3();
        a. input();
        a. output();
    }


    
}
