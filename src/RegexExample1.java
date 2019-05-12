import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String text = "Site1_1.2_ABC_.09ZYdd._";
		String text = "@d506cf33-ffb2-40d5-b543-4dcdc72ec601";

		// String patternString = "^[A-Za-z0-9]*$";
		// String patternString =
		// "^([a-zA-Z])[a-zA-Z_-]*[\\w_-]*[\\S]$|^([a-zA-Z])[0-9_-]*[\\S]$|^[a-zA-Z]*[\\S]$";
		//String patternString = "^[\\w.]+$";
		String patternString = "^[a-zA-Z0-9#&!$@_=-]+$";
		// String patternString =
		// "^([a-zA-Z])[a-zA-Z_-]*[\\\\w_-]*[\\\\S]$|^([a-zA-Z])[0-9_-]*[\\\\S]$|^[a-zA-Z]*[\\\\S]$";
		// String patternString = "^([\\w@#$%^*-=+\\s'\".]{1,255})$";

		Pattern pattern = Pattern.compile(patternString);

		Matcher matcher = pattern.matcher(text);
		boolean matches = matcher.matches();
		if (matches) {
			System.out.println(" Given Input " + text + " is accptable");
		} else {
			System.out.println(" Given Input " + text + " is not accptable");
		}

		
	}
}
