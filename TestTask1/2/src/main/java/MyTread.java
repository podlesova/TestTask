import java.io.File;

public class MyTread implements  Runnable{
    private int value;
    private int number;
    private Writer writer;

    public MyTread(int value, int number, Writer writer) {
        this.value = value;
        this.number = number;
        this.writer = writer;
    }
    @Override
    public  void run() {
        int currentValue = 0;
        while (currentValue < value) {
            File file = new File("out.txt");
            currentValue = writer.getNum(file);
            currentValue += 1;
            System.out.println(currentValue + " Tread-" + number);
            writer.setNum(file,currentValue);
        }
        System.out.println( " Tread-" + number + " закончил работу");
    }
}
