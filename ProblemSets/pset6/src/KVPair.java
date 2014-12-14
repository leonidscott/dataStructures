public class KVPair<K, V> {
	final public K key;
	final public V value;
	
	public KVPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
		
	public String toString() {
		return "[" + key.toString() + "; " + value.toString() + "]";
	}
}