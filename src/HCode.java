
public class HCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PayloadParsar a = new PayloadParsar();
		PayloadParsar b;
		try {
			b = (PayloadParsar) a.clone();
			
			
			System.out.println(a.hashCode());
			System.out.println(b.hashCode());
			
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
