package test.assistant;

public class Example extends SuperExample implements Interface_1, Interface_2 {

    @Order(number = 1)
    private int a;
    @SomeAnnotation(value = 1)
    @Order(number = 2)
    public double b;
    @Order(number = 3)
    private static float c;
    @Order(number = 4)
    final static int ASD = 100;

    private Example(int a, int b) {

    }

    public Example() {}

    Example(int a) {}

    @Order(number = 0)
    public int method_0(int a, float b, int c) {
        return a;
    }

    @Order(number = 1)
    private static int method_1(String s) {
        return 1;
    }

    @Order(number = 2)
    protected float method_2() {
        return 1;
    }

    @Order(number = 3)
    public void method_3() {}

    @Order(number = 4)
    private int method_4() {
        return 0;
    }

    @Order(number = 5)
    private int method_5() {
        return 0;
    }
}