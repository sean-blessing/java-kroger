package sandbox;

public class CarApp {

	public static void main(String[] args) {
		System.out.println("hello");
		
		Car c = new Car("Jeep", "Wrangler", 2013,4,4);
		Boat b = new Boat("Starcraft", "Outrider", 2018, true,4,"bigone");
		
		Car c2 = (Car)c.clone();
		System.out.println(c2);

/*		Vehicle[] vehicles = {c,b};
		
		for (Vehicle v: vehicles) {
			System.out.println(v);
			if (v instanceof Car) {
				System.out.println("its a car");
			}
			else if (v instanceof Boat) {
				System.out.println("its a boat");
			}
			System.out.println("getClass = "+v.getClass().getName());
		}
*/		
		Printable[] vehicles = {c,b};
		
		for (Printable v: vehicles) {
			//System.out.println(v);
			
			v.print();
//			if (v instanceof Car) {
//				System.out.println("its a car");
//			}
//			else if (v instanceof Boat) {
//				System.out.println("its a boat");
//			}
//			System.out.println("getClass = "+v.getClass().getName());
		}
		System.out.println("bye");

	}

}
