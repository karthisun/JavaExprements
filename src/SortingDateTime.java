import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class SortingDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> datestring=new ArrayList<String>();
		datestring.add("01/21/2017 @03:13 PM");
		datestring.add("01/21/2013 @04:37 PM");
		datestring.add("01/21/2020 @10:41 AM");
		datestring.add("01/21/2014 @10:48 AM");
		datestring.add("01/22/2013 @06:16 AM");
		datestring.add("01/22/2013 @06:19 AM");
		datestring.add("01/21/2013 @05:19 PM");
		datestring.add("01/21/2015 @05:19 PM");
		
		for (String s : datestring)
		{
		    System.out.println(s);
		}
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy '@'hh:mm a");
	    Collections.sort(datestring, (s1, s2) -> LocalDateTime.parse(s1, formatter).
	            compareTo(LocalDateTime.parse(s2, formatter)));
	    System.out.println();
	    System.out.println("After sorting.....");
	    System.out.println();
	    
	    
	    for (String s : datestring)
		{
		    System.out.println(s);
		}

	}

}
