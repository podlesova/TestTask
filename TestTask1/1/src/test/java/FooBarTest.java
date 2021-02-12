import junit.framework.TestCase;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FooBarTest extends TestCase {

    private   ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream old;

    @Override
    protected void setUp() throws Exception {
        old=System.out;
        System.setOut(new PrintStream(output));
    }

    public void testFirstSolution(){
        Main.firstSolution(15);
        String result =" 1 2Foo 3 4Bar 5Foo 6 7 8Foo 9Bar 10 11Foo 12 13 14FooBar 15";
        Assert.assertEquals(output.toString().replaceAll("\r\n",""), result);
    }

    public void testSecondSolution(){
        Main.secondSolution(15);
        String result =" 1 2Foo 3 4Bar 5Foo 6 7 8Foo 9Bar 10 11Foo 12 13 14FooBar 15";
        Assert.assertEquals(output.toString().replaceAll("\r\n",""), result);
    }

    public void testThirdSolution(){
        Main.thirdSolution(15);
        String result =" 1 2Foo 3 4Bar 5Foo 6 7 8Foo 9Bar 10 11Foo 12 13 14FooBar 15";
        Assert.assertEquals(output.toString().replaceAll("\r\n",""), result);
    }

    @Override
    protected void tearDown() throws Exception {
        System.setOut(old);
    }
}
