public class DoubleHashingHashtable<K, V> extends OpenAddressHashtable<K, V> {
	
	@Override
	protected int getNextIndex(K key, int probe) {
		return (key.hashCode() + probe*(key.hashCode()%5+1)) % N;
	}

}