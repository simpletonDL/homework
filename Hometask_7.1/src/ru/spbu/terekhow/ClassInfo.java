package ru.spbu.terekhow;

import test.assistant.Order;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Due to this class you can get some code of the any class.
 * <b>Notice,</b> that it isn`t full information of code, it`s
 * only some part of it.
 */
public class ClassInfo {

    /**
     * Print code of the class. Exactly it prints:
     * package, class type (class or interface), class name,
     * super class, implemented interfaces, fields, annotations,
     * methods, constructors, modifiers of fields and methods,
     * parameters and returned type of methods.
     * <b>Notice,</b> that if you want get method and fields in
     * some order, you have to use annotation {@link test.assistant.Order}.
     * In other case they will be print in random order.
     * @param clazz
     */
    public static void printInfo(Class clazz) {
        printPackage(clazz);
        print("\n\n");
        printClassDeclaration(clazz);
        println(" {");

        printFields(clazz);

        printConstructors(clazz);

        printMethods(clazz);
        print("}");
    }

    private static void printPackage(Class clazz) {
        print("package " + clazz.getPackage() + ";");
    }

    private static void printClassDeclaration(Class clazz) {
        printModifier(clazz.getModifiers());
        if (clazz.isInterface()) {
            print("interface ");
        } else {
            print("class ");
        }
        print(clazz.getSimpleName() + " ");
        if (clazz.getSuperclass() != null) {
            print("extends " + clazz.getSuperclass().getSimpleName() + " ");
        }
        printInterfaces(clazz);
    }

    private static void printInterfaces(Class clazz) {
        Class[] interfaces = clazz.getInterfaces();
        if (interfaces.length == 0) {
            return;
        }

        String s = "";
        for (Class targetInterface : interfaces) {
            s += targetInterface.getSimpleName() + ", ";
        }
        s = s.substring(0, s.length() - 2);
        print(s);
    }

    private static void printFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        sortByOrderAnnotation(fields);

        for (Field field : fields) {
            printField(field);
            println();
        }
    }

    private static void printField(Field field) {
        printAnnotations(field.getDeclaredAnnotations());
        printTab();
        printModifier(field.getModifiers());
        print(field.getType().getName() + " " + field.getName() + ";");
    }

    private static void printConstructors(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            println();
            printConstructor(constructor, clazz);
            println();
        }
    }

    private static void printConstructor(Constructor constructor, Class clazz) {
        printTab();
        printModifier(constructor.getModifiers());
        print(clazz.getSimpleName());
        printParametersType(constructor.getParameterTypes());
        print(" {}");
    }

    private static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        sortByOrderAnnotation(methods);

        for (Method method : methods) {
            println();
            printMethod(method);
            println();
        }
    }

    private static void printMethod(Method method) {
        printAnnotations(method.getDeclaredAnnotations());
        printTab();
        printModifier(method.getModifiers());
        print(method.getReturnType().getSimpleName() + " ");
        print(method.getName() + " ");
        printParametersType(method.getParameterTypes());
        print(" {}"); //*/
    }

    private static void printAnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            printAnnotation(annotation);
            println();
        }
    }

    private static void printAnnotation(Annotation annotation) {
        printTab();
        print("@" + annotation.annotationType().getSimpleName());

        Method[] methodsAnnotation = annotation.annotationType().getDeclaredMethods();
        if (methodsAnnotation.length == 0) {
            return;
        }
        String s = "(";
        for (Method method : methodsAnnotation) {
            s += method.getName();
            try {
                s +=" = " + method.invoke(annotation).toString();
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            s += ", ";
        }
        s = s.substring(0, s.length()-2);
        s += ")";
        print(s);
    }

    private static void printTab() {
        print("    ");
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void println(String s) {
        System.out.print(s + "\n");
    }

    private static void println() {
        System.out.print("\n");
    }

    private static void printParametersType(Class[] parameters) {
        print("(");
        if (parameters.length == 0) {
            print(")");
            return;
        }

        String s = "";
        for (Class parameter : parameters) {
            s += parameter.getSimpleName() + ", ";
        }
        s = s.substring(0, s.length() - 2);

        print(s + ")");
    }

    private static void printModifier(int mod) {
        if (Modifier.isPublic(mod)) {
            print("public ");
        }
        if (Modifier.isPrivate(mod)) {
            print("private ");
        }
        if (Modifier.isProtected(mod)) {
            print("protected ");
        }

        if (Modifier.isAbstract(mod)) {
            print("abstract ");
        }
        if (Modifier.isStatic(mod)) {
            print("static ");
        }
        if (Modifier.isFinal(mod)) {
            print("final ");
        }
    }

    private static <Type extends AnnotatedElement> void sortByOrderAnnotation(Type[] array) {
        Arrays.sort(array, new Comparator<Type>() {
            @Override
            public int compare(Type o1, Type o2) {
                Order order1 = o1.getAnnotation(Order.class);
                Order order2 = o2.getAnnotation(Order.class);
                if (order1 == null && order2 == null) {
                    return 0;
                } else if (order1 == null) {
                    return 1;
                } else if (order2 == null) {
                    return -1;
                } else {
                    return (order1.number() - order2.number());
                }
            }
        });
    }
}
