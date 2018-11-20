import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number:  ");
		int a = sc.nextInt();
		
		System.out.println("Enter another number:  ");
		int b = sc.nextInt();
		
		System.out.println("Enter your name:  ");
		String name = sc.next();
		
		System.out.println(name + ", your sum is " + (a + b));
		sc.close();
		System.out.println("Bye");

	}

}
