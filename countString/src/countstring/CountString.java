/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package countstring;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CountString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String c;
        char a;
        int count =0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập vào chuỗi:");
        c = sc.nextLine();
        System.out.print("Mời bạn nhập vào ký tự cần đếm:");
        a = sc.next().charAt(0);
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i)==a) {
                count++;
            }
        }
        System.out.println("Tổng số ký tự "+ a + " có trong mảng là: " + count);
    }
    
}
