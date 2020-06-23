package Marcin;

public class Playground {
    public static void main(String[] args) {


        System.out.println("if (intValue >= 100) {" +
            "hundreds = hundredsArray[intValue / 100] + \"hundred\";" +
            "intValue = intValue - (intValue / 100);" +
        "\\}");
int value = 265;
        System.out.println(value);
        System.out.println("value%100  " + value%100);
        System.out.println("value%10 wyciąga jednostki " + value%10);
        System.out.println("(value%100)%10 też wyciąga jednostki " + (value%100)%10 + "\n");
        System.out.println("value/100 wyciąga setki " + value/100);
        System.out.println("value/10  " + value/10);
        System.out.println("(value/100)/10 NIEPRZYDATNE " + (value/100)/10 + "\n");
        int nextValue = value - (100 * (value / 100));
        System.out.println("value - (100 * (value/100))  " + nextValue);
        System.out.println("value - (100 * (value/100)) / 10 wyciąga dziesiątki " + nextValue/10 + "\n");

        System.out.println("value " + value);
        System.out.println("value/100 wyciąga setki " + value/100);
        System.out.println("value - (100 * (value/100)) / 10 wyciąga dziesiątki " + nextValue/10);
        System.out.println("value%10 wyciąga jednostki " + value%10 + "\n");



//        if (intValue >= 10) {
//            tens = tensArray[intValue / 10];
//            intValue = intValue - (intValue / 10);
//        }
//
//        if (intValue >=0){
//            ones = onesArray[intValue];
//        }
    }
}
