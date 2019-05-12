package StreamAPI;

// a simple program to demonstrate the use of stream in java
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

class Demo {
	public static void main(String args[]) {

		// create a list of integers
		List<Integer> number = Arrays.asList(2, 3, 4, 5);

		// demonstration of map method
		List<Integer> square = number.stream().map(x -> x * x).
				collect(Collectors.toList());
		System.out.println(square);

		// create a list of String
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

		// demonstration of filter method
		List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);

		// demonstration of sorted method
		List<String> show = names.stream().sorted().collect(Collectors.toList());
		System.out.println(show);

		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);

		// collect method returns a set
		Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println(squareSet);

		// demonstration of forEach method
		number.stream().map(x -> x * x).forEach(y -> System.out.println(y));

		// demonstration of reduce method
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);

		System.out.println(even);
		
		System.out.println("Function");
		Predicate<Integer> p = i -> (i > 10);
		System.out.println(p.test(100));
		System.out.println(p.test(7));
		// System.out.println(p.test(true));
		
		
		System.out.println("Function");
		Function<String, Integer> f = s1 -> s1.length();
		System.out.println(f.apply("Durga"));
		System.out.println(f.apply("Soft"));
	}
}
