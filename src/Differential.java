import java.util.Scanner;
import java.lang.Math;

public class Differential {

   private static int n;
   private static double a,h;
   private static double[] xs,ys,computingError;

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

    public static double[] getXs() {
        return xs;
    }

    public static void setXs(double[] xs) {
        Differential.xs = xs;
    }

    public static double[] getYs() {
        return ys;
    }

    public static void setYs(double[] ys) {
        Differential.ys = ys;
    }

    public static double[] getComputingError() {
        return computingError;
    }

    public static void setComputingError(double[] computingError) {
        Differential.computingError = computingError;
    }

    public static String userInput() {
       Scanner myObj = new Scanner(System.in);
       return myObj.nextLine();
   }

   public static boolean checkN(String n) {
       try {
           int value = Integer.parseInt(n);
           return value >= 1 && value < 10;
       } catch (Exception e) {
           return false;
       }
   }

   public static boolean checkA(String a) {
       try {
           double value = Double.parseDouble(a.replace(',', '.'));
           return value > 0.0 && value <= 2.0;
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
       allocationXYs(getN());
       allocationComputingError(getN());
   }

   public static void inputA() {
       String a;
       System.out.println("Enter real number greater than 0.0 and less than or equal to 2.0: ");
       a = userInput();
       while(!checkA(a)) {
           System.out.println("Sorry try again");
           System.out.println("Enter real number greater than 0.0 and less than or equal to 2.0: ");
           a = userInput();
       }
       setA(Double.parseDouble(a.replace(',', '.')));
   }

   public static void allocationXYs(int n) {
       setXs(new double[n+1]);
       setYs(new double[n+1]);
       getXs()[0] = 0.0;
       getYs()[0] = -1.0;
   }

   public static void allocationComputingError(int n) {
       setComputingError(new double[n]);
   }

   public static void  fillXs() {
       setH(getA()/getN());
       for(int i=1;i<=getN();i++) {
           getXs()[i] = i * getH();
       }
    }

    public static void showXs() {
       for(int i=0;i<=getN();i++) {
           System.out.println("x[" + i + "] = " +getXs()[i]);
       }
       System.out.println("");
    }

    public static void showYs() {
        for(int i=0;i<=getN();i++) {
            System.out.println("y[" + i + "] = " +getYs()[i]);
        }
        System.out.println("");
    }

    public static void showComputingError() {
        for(int i=0;i<getN();i++) {
            System.out.println("computingError[" + i + "] = " +getComputingError()[i]);
        }
        System.out.println("");
    }

    public static double getMaxComputingError() {
       double max = getComputingError()[0];
       for(int i=1;i<getN();i++) {
           if(max < getComputingError()[i])
               max = getComputingError()[i];
       }
        return max;
    }

    public static double fxy(double x,double y) {
       return y + 2 * Math.cos(x);
    }

    public static double fx(double x) {
       return Math.sin(x) - Math.cos(x);
   }

    public static void eulerMethod() {
       System.out.println("Euler's Method:");
       for(int i=0;i<getN();i++) {
           getYs()[i+1] = getYs()[i] + (getH() * fxy(getXs()[i],getYs()[i]));
       }
       for(int i=1;i<=getN();i++) {
           getComputingError()[i-1] = Math.abs(getYs()[i] - fx(getXs()[i]));
       }
    }


    public static void heunMethod() {
        System.out.println("Heun's Method:");
        for(int i=0;i<getN();i++) {
            getYs()[i+1] = getYs()[i] + getH()/2.0 * (fxy(getXs()[i],getYs()[i]) + fxy(getXs()[i+1],getYs()[i] + getH() * fxy(getXs()[i],getYs()[i])));
        }
        for(int i=1;i<=getN();i++) {
            getComputingError()[i-1] = Math.abs(getYs()[i] - fx(getXs()[i]));
        }

    }

    public static void main(String[] args) {
        inputN();
        inputA();
        fillXs();
        showXs();
        eulerMethod();
        showYs();
        showComputingError();
        System.out.println("Maximum Computing Error : " + getMaxComputingError() + "\n");
        heunMethod();
        showYs();
        showComputingError();
        System.out.println("Maximum Computing Error : " + getMaxComputingError());

    }

}
