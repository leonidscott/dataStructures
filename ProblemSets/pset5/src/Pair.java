// Lenny Scott, pset 5
public class Pair<K extends Comparable<K>, V> {
	final public K key;
	final public V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public boolean equals(Object other) {
		if (! (other instanceof Pair)) return false;
		Pair<K,V> otherPair = (Pair<K,V>) other;
		return (key.equals(otherPair.key) && value.equals(otherPair.value));
	}
	
	public String toString() {
		return "[" + key.toString() + "; " + value.toString() + "]";
	}
}
