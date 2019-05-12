package MyHashMapExprement;

class ConcurrHashMapCustom<K, V> {

	private Entry<K, V>[] table;
	private int capacity = 16;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public ConcurrHashMapCustom() {
		table = new Entry[capacity];
	}

	public void put(K newKey, V data) {
		if (newKey == null)
			return;

		int index = hash(newKey);

		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);
		if (table[index] == null) {   // then it is new segment/bucket
			table[index] = newEntry;
		} else { 					// then it is existing segment/bucket
			synchronized (this) {		// when multiple threads try to put the value, only it is possible to allow only
											// one thread who ever accired the lock
				Entry<K, V> previous = null;
				Entry<K, V> current = table[index];

				while (current != null) {
					if (current.key.equals(newKey)) {
						if (previous == null) {
							newEntry.next = current.next;
							table[index] = newEntry;
							return;
						} else {
							newEntry.next = current.next;
							previous.next = newEntry;
							return;
						}
					}
					previous = current;
					current = current.next;
				}
				previous.next = newEntry;
			}

		}
	}

	public V get(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next;
			}
			return null;
		}
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

}

public class CustomConcurrentHM {

	public static void main(String[] args) {
		ConcurrHashMapCustom<Integer, Integer> concurrHashMap = new ConcurrHashMapCustom<Integer, Integer>();
		concurrHashMap.put(12, 5657567);
		concurrHashMap.put(23, 456);
		concurrHashMap.put(21, 1342);
		concurrHashMap.put(25, 1521);
		concurrHashMap.put(33, 15);
		

		System.out.println("get the value of 21" + concurrHashMap.get(21));
		System.out.println("get the value of some randam number - 51" + concurrHashMap.get(51));

	}
}
