import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CheckingDuplication {

	public static void main(String[] args) {
		String[] numbers = new String[]{"17e0a5a1-f23a-40fd-a302-87b9532b5cfb","17e0a5a1-f23a-40fd-a302-87b9532b5cf1"};
		 Set<String> allItems = new HashSet<>();
		 Set<String> duplicates = Arrays.stream(numbers)
		    .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
		    .collect(Collectors.toSet());
		 System.out.println(duplicates); 
	}

}
