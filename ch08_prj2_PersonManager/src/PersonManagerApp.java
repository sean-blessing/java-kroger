
public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");
		
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			String custType = Console.getString("Create customer or employee?",
												"c", "e");
			Person p = null;
			String fName = Console.getString("Enter first name:  ");
			String lName = Console.getString("Enter last name:  ");
			if (custType.equals("c")) {
				String custNumber = Console.getString("Enter customer number:  ");
				p = new Customer(fName, lName, custNumber);
			}
			else if(custType.equals("e")) {
				String ssn = Console.getString("Enter ssn:  ");
				p = new Employee(fName, lName, ssn);
			}
			
			System.out.println("You created a new "+p.getClass().getName());
			System.out.println(p);
			
			choice = Console.getString("Continue?? (y/n)  ");
		}
		
		
		System.out.println("Bye");

	}

}
