public class LinearProbingHashtable<K, V> extends OpenAddressHashtable<K, V> {

	private static final int stepSize = 7;

	@Override
	protected int getNextIndex(K key, int probe) {
		return (key.hashCode() + probe * stepSize) % N;
	}

}