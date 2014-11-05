// Lenny Scott, Take Home 2: Interface
public interface SortingList<E extends Comparable<E>> extends Iterable<E> {
    /*
     * Return true if this list contains no elements, and false otherwise
     */
     public boolean isEmpty();
	
    /*
     * Returns the number of elements in this list. 
     */
    public int size();

    /*
     * Returns the number of elements in the central trunk of this list, which
     * is also the number of different values in the list. 
     */
    public int uniqueValueCount();
    
    /*
     * Adds the specified element to the list, in its appropriate location
     */
    public void add(E item);
    
    /*
     * Returns the number of items in the list with the same sorting value as item. That is, the number of
     * items for which item.compareTo(itemInList) == 0.  Note that the method should return 0 if the item 
     * is not found in the list.
     */
    public int frequencyOf(E item);

    /*
     * Returns the element at the specified position in this list. The index refers to the position the element
     * would be in when the list is iterated.
     * 
     * Throws a ListIndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    public E get(int index) throws ListIndexOutOfBoundsException;
    

    /*
     * Removes the element at the specified position in this list (see get for definition of "position"), and
     * shifts any subsequent elements to the "left" (subtracts one from their indices). 
     * 
     * Throws a ListIndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */ 
    public void remove(int index) throws ListIndexOutOfBoundsException;
    
    /**
     * Removes all of the elements from this list. 
     */
    public void clear();


}