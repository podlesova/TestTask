import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("out.txt"))
        {
            writer.write("0");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("n:");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        Writer writer = new Writer();
        MyTread myTread1 = new MyTread(value, 1, writer);
        MyTread myTread2 = new MyTread(value, 2, writer);
        new Thread(myTread1).start();
        new Thread(myTread2).start();
    }
}
