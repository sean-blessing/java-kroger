import java.util.ArrayList;
import java.util.List;

public class ArrayListRefTypeDemoApp {

	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1,"a"));
		items.add(new Item(2,"b"));
		items.add(new Item(3,"c"));
		items.add(new Item(4,"d"));
		items.add(new Item(5,"e"));
		
		String choice = "";
		
		while (!choice.equalsIgnoreCase("n")) {
			int id = Console.getInt("id to retrieve:  ");
			
		}
		
	}

}
