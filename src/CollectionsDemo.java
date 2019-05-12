import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	   public static void main(String args[]) {

	      // create two lists    
	      List<String> srclst = new ArrayList<String>(5);
	      List<String> destlst = new ArrayList<String>(10);

	      
	      
	      // populate two lists
	      srclst.add("Java");
	      srclst.add("is");
	      srclst.add("best");

	      destlst.add("C++");
	      destlst.add("is");
	      destlst.add("older");

	      // copy into dest list
	      Collections.copy(destlst, srclst);            

	      System.out.println("Value of source list: "+srclst);
	      System.out.println("Value of destination list: "+destlst);
	      
	      //System.out.println("HC of source list: "+srclst.hashCode());
	      //System.out.println("HC of destination list: "+destlst.hashCode());
	      
	      try {
				List<String> destlst123 = srclst.getClass().newInstance();
				System.out.println("Value of destlst123 list: "+destlst123);
				System.out.println("HC of source list: "+srclst.hashCode());
				System.out.println("destlst123 of source list: "+destlst123.hashCode());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }    
	}
