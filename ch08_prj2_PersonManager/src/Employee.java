
public class Employee extends Person {
	private String ssn;

	public Employee(String firstName, String lastName, String ssn) {
		super(firstName, lastName);
		this.ssn = ssn;
	}

	public String getSsn() {
		int begIdx = ssn.length() - 4;
		return "XXX-XX-"+ssn.substring(begIdx, (ssn.length()));
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return super.toString()+"\nSSN:  " + getSsn();
	}
	
	
}
