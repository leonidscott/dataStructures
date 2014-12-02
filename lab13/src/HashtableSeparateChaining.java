import java.awt.Paint;
import java.util.LinkedList;

public class HashtableSeparateChaining<K, V> implements OurHashtable<K, V> {
	
	private static final int defaultNumberOfBuckets = 20;
	private int numberOfBuckets;
	private int count = 0;
	
	private LinkedList<KVPair<K, V>>[] buckets;
	
	
	public HashtableSeparateChaining() {
		this.numberOfBuckets = defaultNumberOfBuckets;
		this.setup();
	}
	
	public HashtableSeparateChaining(int numberOfBuckets) {
		this.numberOfBuckets = numberOfBuckets;
		this.setup();
	}
	
	private void setup() {
		buckets = new LinkedList[numberOfBuckets];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<KVPair<K, V>>();
		}
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void put(K key, V value) {
		buckets[key.hashCode() % (buckets.length)].add(new KVPair<K, V>(key, value));
		count++;
	}

	@Override
	public V get(K key) {
		for (int i = 0; i < buckets[key.hashCode() % (buckets.length)].size(); i++) {
			if (key == buckets[key.hashCode() % (buckets.length)].get(i).key) {
				return buckets[key.hashCode() % (buckets.length)].get(i).value;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		for (int i = 0; i < buckets.length - 1; i++) {
			buckets[i] = null;
		}
		count = 0;
	}

}