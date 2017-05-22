package ru.spbu.terekhow;

import test.assistant.Example;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        ClassInfo.printInfo(   Example.class);
        /*Integer arr[] = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a % 10 < b % 10) return -1;
                else if (a % 10 > b % 10) return 1;
                else return 0;
            }
        });

        for (int i = 0; i < 100; i++) {
            System.out.println(arr[i]);
        } //*/

        /*Class clazz = Example.class;
        Method methods[] = clazz.getDeclaredMethods();

        Field field;

        for (Method method : methods) {
            System.out.print(method.getName() + " ");
            Order order = method.getAnnotation(Order.class);
            if (order != null) {
                System.out.println(order.number());
            }
        } //*/

        /*Class intClass = Example.class;
        System.out.println(intClass.getModifiers());
	    Method methods[] = intClass.getDeclaredMethods();
	    for (Method m : methods) {
	        System.out.print(m.getReturnType().getName() + " ");
            System.out.print(m.getModifiers() + " ");
	        System.out.print(m.getName());


	        System.out.print("(");
	        Class paramTypes[] = m.getParameterTypes();
	        for (Class param : paramTypes) {
	            System.out.print(param.getSimpleName() + " ");
            }
            System.out.println(")");
        }//*/
    }
}
