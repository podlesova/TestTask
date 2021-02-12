import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        firstSolution(value);
        secondSolution(value);
        thirdSolution(value);
    }
    public static void  firstSolution(int value){
        for (int i = 1; i <= value; i++){
            printValue(i);
        }
    }

    public static void  secondSolution(int value){
        Stream.iterate(1, n -> n + 1).limit(value).forEach(Main::printValue);
    }

    public static void  thirdSolution(int value){
        for (int i = 1; i <= value; i++){
            if (i % 3 == 0)
                System.out.print("Foo");
            if (i % 5 == 0)
                System.out.print("Bar");
            System.out.println(" " + i);
        }
    }

    private  static void printValue(int i){
        if ((i % 3 == 0) && (i % 5 == 0))
            System.out.print("FooBar");
        else if (i % 3 == 0)
            System.out.print("Foo");
        else if (i % 5 == 0)
            System.out.print("Bar");
        System.out.println(" " + i);
    }

}
