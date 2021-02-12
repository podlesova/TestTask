import java.io.*;

public class Writer  {


    public synchronized int getNum(File file){
        int value = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String s = reader.readLine();
            if (s == null){ wait();
                            s = reader.readLine();}
            value =Integer.parseInt(s);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return value;
    }

    public synchronized void setNum(File file, int value){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            writer.write(String.valueOf(value));
            writer.flush();
            notify();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
