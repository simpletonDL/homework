package test.assistant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * If you want print code of class using static {@link ru.spbu.terekhow.ClassInfo#printInfo(Class)}
 * and you want to get methods in the some order you have to mark method this annotation and
 * set number in the increasing order.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    /**
     * Number by whitch fiesld and method are sorted.
     */
    int number();
}
