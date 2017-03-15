package com.company;

public class Main {
	public static void main(String[] args) {
		Stack stack = new StackByArray(3);
		testStack(stack);
		stack = new StackByPointers();
		testStack(stack);

		System.out.println(Calculator.calculute("( 1 + 2 ) * 3")); // 9
		System.out.println(Calculator.calculute("( ( 1 + 5 ) * 3 - 8 ) / 2")); // 5
		System.out.println(Calculator.calculute("( 1 + 2 ) * ( 3 - 1 )")); // 6
		System.out.println(Calculator.calculute("5 + 3 * 2 + 1")); // 12
    }

    /*
    Функция для проверки стека - необходимый рзмер 3 (для stackByArray)
     */
    public static void testStack(Stack s) {
		s.push("1");
		s.showInConsole(); // 1
		s.push("2");
		s.showInConsole(); // 1 2
		s.push("3");
		s.showInConsole();// 1 2 3
		s.pop();
		s.showInConsole(); // 1 2
		s.push("5");
		s.showInConsole(); // 1 2 5
		s.pop();
		s.showInConsole(); // 1 2
		s.pop();
		s.showInConsole(); // 1
		s.pop();
		s.showInConsole(); //
		s.pop(); // Stack is empty
		System.out.println("*************");
	}
}