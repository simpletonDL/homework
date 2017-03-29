package ru.spbu.terekhow;

public class Main {

    public static void main(String[] args) {
        Holder<String> a = new Holder<String>("123");
        a.set("3");
        print(a.get());
    }
    public static void print(String s) {
        System.out.println(s);
    }
}

class Holder<T> {
    private T obj;

    public Holder(T obj) {
        this.obj = obj;
    }

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return this.obj;
    }
}