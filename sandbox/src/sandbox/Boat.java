package sandbox;

public class Boat extends Vehicle {
	
	private boolean floats;
	private int lifeJackets;
	private String propeller;

	public Boat(String make, String model, int year, boolean floats,
				int lifeJackets, String propeller) {
		super(make, model, year);
		this.floats = floats;
		this.lifeJackets = lifeJackets;
		this.propeller = propeller;
	}

	public boolean isFloats() {
		return floats;
	}

	public void setFloats(boolean floats) {
		this.floats = floats;
	}

	public int getLifeJackets() {
		return lifeJackets;
	}

	public void setLifeJackets(int lifeJackets) {
		this.lifeJackets = lifeJackets;
	}

	public String getPropeller() {
		return propeller;
	}

	public void setPropeller(String propeller) {
		this.propeller = propeller;
	}

	@Override
	public String toString() {
		return super.toString() + "Boat [floats=" + floats + ", lifeJackets=" + lifeJackets + ", propeller=" + propeller + "]";
	}

	@Override
	public void print() {
		System.out.println("Boat floats? "+floats);
		
	}

}
