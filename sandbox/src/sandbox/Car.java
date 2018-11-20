package sandbox;

public class Car extends Vehicle implements Cloneable {
	private int wheels;
	private int doors;
	
	public Car(String make, String model, int year, int wheels, int doors) {
		super(make, model, year);
		this.wheels = wheels;
		this.doors = doors;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return super.toString() + "Car [wheels=" + wheels + ", doors=" + doors + "]";
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public void print() {
//		System.out.println("Car has "+ wheels + " wheels.");
//		
//	}

}
