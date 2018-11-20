package sandbox;

public interface Printable {
	//void print();
	default void print() {
		System.out.println(toString());
	}
}
