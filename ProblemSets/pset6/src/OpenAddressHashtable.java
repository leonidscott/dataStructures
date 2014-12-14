//Lenny Scott, pset6

public abstract class OpenAddressHashtable<K, V> implements OurHashtable<K,V> {
	public static final int N = 101;
	private int elementCount = 0;
	private KVPair<K,V>[] hashtable = new KVPair[N];
	private double loadFactor = 0;
	private int collisionCout = 0;
	
	
	@Override
	public boolean isEmpty() {
		return this.elementCount == 0;
	}

	@Override
	public int size() {
		return this.elementCount;
	}

	@Override
	public void put(K key, V value) {
		if (key == null) throw new NullPointerException();
		
		boolean foundSpace = false;
		for (int probe = 0; !foundSpace && probe <= N; probe++) {
			int spot = getNextIndex(key, probe);
			if (probe != 0) {
				collisionCout++;
			}
			if(hashtable[spot] == null){
				hashtable[spot] = new KVPair<K, V>(key, value);
				foundSpace = true;
				elementCount++;
				int doubleElementCount = elementCount;
				loadFactor = (double)doubleElementCount/N;
				//System.out.println("element count: " + elementCount + " load factor: " + loadFactor);
			}
		}
		if (!foundSpace) { //have searched all indices without success (in linear or double hashing)
			throw new HashtableFullException(this);
		}
	}

	@Override
	public V get(K key) {
		if (key == null) throw new NullPointerException(); // otherwise will not throw exception if hashtable is empty
		
		for (int probe = 0; probe < N; probe++) {
			if(hashtable[getNextIndex(key, probe)] == null){
				return null;
			}
			else{
				if(hashtable[getNextIndex(key, probe)].key.equals(key)){
					return hashtable[getNextIndex(key, probe)].value;
				}
			}
		}
		// not found
		return null;
	}

	@Override
	public void clear() {
		this.hashtable = new KVPair[N];
		this.elementCount = 0;
	}
	

	public String toString() {
		String all = "";
		for (KVPair p : hashtable) {
			all += p;
		}
		return all;
	}
	
	public double getLoadFactor() {
		return loadFactor;
	}
	
	public int getCollisionCount() {
		return this.collisionCout;
	}
	
	
	/**
	 * Subclasses must implement this method, calculating the index in the manner
	 * appropriate to that subclass.
	 * @param key - the key whose next appropriate index is to be calculated
	 * @param probe - the number of previous attempts to find an index
	 * @return
	 */
	abstract protected int getNextIndex(K key, int probe);

}