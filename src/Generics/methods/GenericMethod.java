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
        System.out.println("--------generic tip döndüren method--------");
        int n=getFirst(intArr);
        System.out.println(n);
        System.out.println(getFirst(strArr));
        System.out.println("--------birden fazla generic tip kullanan method--------");
        printArrAndObject(strArr,55);
        printArrAndObject(intArr,"Harika");

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
    //sonuç döndüren generic method
    public static <T> T getFirst(T[] arr){
        T first=arr[0];
        return first;
    }

    //birden fazla generic tip parametresi alan method
    //methodun iki farklı parametresinin data tipi..
    public static <S,U> void printArrAndObject(S[] arr,U object){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
        System.out.println(object);

    }

}
