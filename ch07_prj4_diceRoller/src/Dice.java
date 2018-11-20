
public class Dice {

	private Die die1;
	private Die die2;
	
	public Dice() {
		die1 = new Die();
		die2 = new Die();
	}

	public Die getDie1() {
		return die1;
	}

	public void setDie1(Die die1) {
		this.die1 = die1;
	}

	public Die getDie2() {
		return die2;
	}

	public void setDie2(Die die2) {
		this.die2 = die2;
	}
	
	public int getDie1Value ()  {
		return die1.getValue();
	}
	
	public int getDie2Value ()   {
		return die2.getValue();
	}
	
	public int getSum() {
		return getDie1Value() + getDie2Value();
	}
	
	public void roll() {
		die1 = new Die();
		die2 = new Die();
	}
	
	public void printRoll() {
		System.out.println("Die1:  "+die1.getValue());
		System.out.println("Die2:  "+die2.getValue());
		int sum = getSum();
		System.out.println("Total: "+sum);
		
		if (sum==7)
			System.out.println("Craps!");
		else if (sum==2)
			System.out.println("Snake eyes!");
		else if (sum==12) {
			System.out.println("Box cars!");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	

}
