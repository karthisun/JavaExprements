import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyListGeneric<T1> {
	private List<T1> values;

	void add(T1 value) {
		values.add(value);
	}

	void remove(T1 value) {
		values.remove(value);
	}

	T1 get(int index) {
		return values.get(index);
	}
}