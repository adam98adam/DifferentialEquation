import java.util.Scanner;
import java.lang.Math;

public class Differential {

   private static int n;
   private static double a,h,x[];

   public static int getN() {
       return n;
   }

   public static void setN(int n) {
       Differential.n = n;
   }

   public static double getA() {
       return a;
   }

   public static void setA(double a) {
       Differential.a = a;
   }

   public static double getH() {
       return h;
   }

   public static void setH(double h) {
       Differential.h = h;
   }

   public static String userInput() {
       Scanner myObj = new Scanner(System.in);
       return myObj.nextLine();
   }

   public static boolean checkN(String n) {
       try {
           int value = Integer.parseInt(n);
           return value > 1 && value < 10;
       } catch (Exception e) {
           return false;
       }
   }

   public static boolean checkA(String a) {
       try {
           double value = Double.parseDouble(a.replace(',', '.'));
           return value > 0.0 && value < 10.0;
       } catch (Exception e) {
           return false;
       }
   }

   public static void inputN() {
       String n;
       System.out.println("Enter natural number less than 10: ");
       n = userInput();
       while(!checkN(n)) {
           System.out.println("Sorry try again");
           System.out.println("Enter natural number less than 10: ");
           n = userInput();
       }
       setN(Integer.parseInt(n));
   }

   public static void inputA() {
       String a;
       System.out.println("Enter real number greater than 0.0 and less than 10.0: ");
       a = userInput();
       while(!checkA(a)) {
           System.out.println("Sorry try again");
           System.out.println("Enter real number greater than 0.0 and less than 10.0: ");
           a = userInput();
       }
       setA(Double.parseDouble(a.replace(',', '.')));
   }

    public static void main(String[] args) {
        inputN();
        inputA();

    }

}
