
public class DiceRollerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller App!");

		String choice = Console.getString("Roll the dice?");
		while (choice.equalsIgnoreCase("y")) {
			Dice d = new Dice();
			d.printRoll();
			choice = Console.getString("Roll again?  ");
		}
		System.out.println("Bye");
	}

}
