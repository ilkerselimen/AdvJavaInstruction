package Generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr={1,23,4,65,9};
        Double[]  doubleArr={0.5,2.3,45.9,11.75};
        String[]  strArr={"Java","harika","bir","programlama","dili:)"};
        System.out.println("--------generic olmayan method--------");
        printArr(intArr);
        printArr(doubleArr);
        printArr(strArr);
        System.out.println("--------generic method--------");
        printAllArray(intArr);
        printAllArray(doubleArr);
        printAllArray(strArr);

    }
    //arrayleri yazdırmak için method
    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //overloading...
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArr(String[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //generic method
    public static <T> void printAllArray(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

}
