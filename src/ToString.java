
public class ToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal("Tommy", "Dog");
		System.out.println(animal.toString());// Animal [name=Tommy, type=Dog]
		
		for(int i=0,j=0; i < 10 ; i++,j--) {
			System.out.print(j);
		}
	}

}

class Animal {
	public Animal(String name, String type) {
		this.name = name;
		this.type = type;
	}

	String name;
	String type;

	public String toString() {
		return "Animal [name=" + name + ", type=" + type + "]";
	}
}
