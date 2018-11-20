package business;

public enum CustomerType {
	RETAIL,
	TRADE,
	COLLEGE;

	@Override
	public String toString() {
		String str = "";
		switch(this.ordinal()) {
		case 0:
			str = "Retail customer";
			break;
		case 1:
			str = "Trade customer";
			break;
		case 2:
			str = "College customer";
			break;
		}
		return str;
	}
}
