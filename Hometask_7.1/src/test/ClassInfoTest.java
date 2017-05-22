package test;

import org.junit.Assert;
import org.junit.Test;
import ru.spbu.terekhow.ClassInfo;
import test.assistant.Example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ClassInfoTest {
    @Test
    public void printInfo() {
        String expected = "package package test.assistant;" + "\n\n" +
                          "public class Example extends SuperExample Interface_1, Interface_2 {" +  "\n" +
                          "    @Order(number = 1)" + "\n" +
                          "    private int a;" + "\n" +
                          "    @SomeAnnotation(value = 1)" + "\n" +
                          "    @Order(number = 2)" + "\n" +
                          "    public double b;" + "\n" +
                          "    @Order(number = 3)" + "\n" +
                          "    private static float c;" + "\n" +
                          "    @Order(number = 4)" + "\n" +
                          "    static final int ASD;" + "\n" +
                          "\n" +
                          "    Example(int) {}" + "\n" +
                          "\n" +
                          "    public Example() {}" + "\n" +
                          "\n" +
                          "    private Example(int, int) {}" + "\n" +
                          "\n" +
                          "    @Order(number = 0)" + "\n" +
                          "    public int method_0 (int, float, int) {}" + "\n" +
                          "\n" +
                          "    @Order(number = 1)" + "\n" +
                          "    private static int method_1 (String) {}" + "\n" +
                          "\n" +
                          "    @Order(number = 2)" + "\n" +
                          "    protected float method_2 () {}" + "\n" +
                          "\n" +
                          "    @Order(number = 3)" + "\n" +
                          "    public void method_3 () {}" + "\n" +
                          "\n" +
                          "    @Order(number = 4)" + "\n" +
                          "    private int method_4 () {}" + "\n" +
                          "\n" +
                          "    @Order(number = 5)" + "\n" +
                          "    private int method_5 () {}" + "\n" +
                          "}";

        String actual = getConsoleOut(Example.class);
        assertEquals(expected, actual);
    }

    private String getConsoleOut(Class clazz) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream previous = System.out;

        System.setOut(printStream);

        ClassInfo.printInfo(clazz);

        System.setOut(previous);
        printStream.close();

        String out = byteArrayOutputStream.toString();
        return out;
    }
}