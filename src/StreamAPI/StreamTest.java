package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
	}

}
