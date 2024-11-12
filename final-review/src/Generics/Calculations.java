package Generics;

public class Calculations <T extends Number> {
    T n1;
    T n2;

    void doCalculation(T n1, T n2, String calType) {
        System.out.println(n1.getClass().getSimpleName());
        if (calType.equals("add")) {
            System.out.println( n1.intValue() + n2.intValue());
        } else if (calType.equals("sub")) {

        } else if (calType.equals("div")) {

        } else {

        }
    }

    public static void main(String[] args) {
        Calculations calculations = new Calculations();
        calculations.doCalculation(1, 5, "add");
    }
}
