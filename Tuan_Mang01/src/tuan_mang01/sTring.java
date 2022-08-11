/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

/**
 *
 * @author Admin
 */
public class sTring {
    public static void main(String[] args){
        String s1="Lop CS311 X";
        String s5="Lop Cs311 X";
        System.out.println(":"+s1+":");
        System.out.print(":");
        for(int i=0; i<s1.length();i++)
            System.out.print(s1.charAt(i));
        System.out.println(":");
        String s2=s1+"Học java";
        System.out.println(":"+s2+":");
        String s3=s1.substring(5);
        System.out.println("s3 :"+s3+":");
        String s4=s1.substring(5,9);
        System.out.println("s4"+s4+":");
        System.out.println(s1.equals(s5));
        System.out.println(s1.equalsIgnoreCase(s5));

        
    }
}
