public class QuadraticProbingHashtable<K, V> extends OpenAddressHashtable<K, V> {

	private static final int stepSize1 = 7;
	private static final int stepSize2 = 11;
	
	@Override
	protected int getNextIndex(K key, int probe) {
		
		return (key.hashCode() + ((probe * stepSize1) + ((probe*probe) * stepSize2))) % N;
	}
}