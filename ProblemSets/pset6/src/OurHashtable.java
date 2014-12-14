public interface OurHashtable<K, V> {
	
	/*
	 * returns true if the table is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/*
	 * returns the number of elements in the table
	 */
	public int size();
	
	/*
	 * Adds a given value indexed with a given key to the table according 
	 * to the key's hash
	 */
	public void put(K key, V value);

	/*
	 * returns a value associated with the given key in this table.
	 * If multiple values are associated with this key, any one may be returned.
	 * If there is no element associated with this key, null is returned.
	 * 
	 * throws NullPointerException if the key is null        
	 */
	public V get(K key);
	
	/*
	 * Clears all elements from a given table.
	 * The resulting table is empty.
	 */
	public void clear();

}