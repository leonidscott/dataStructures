//Preston Miller, Ben Villano, Lenny Scott
public class CountingSorter {

	public static void countingSort(Integer[] sorting) {
		
		/* Determine range, since all we know is that we have Integers */
		int highest = sorting[0];
		int lowest = sorting[0];
		for(int item : sorting){
			if(item < lowest){
				lowest = item;
			}else if(highest < item){
				highest = item;
			}
		}
		
		/* Count frequencies of different Integers */
		int[] frequency = new int[highest-lowest+1];
		for(int i = 0; i < sorting.length;i++){
			frequency[sorting[i] - lowest]++;
		}
	
		/* Convert frequencies to indices */
		frequency[0]--;
		for(int i = 1; i < frequency.length; i++){
			frequency[i] += frequency[i-1];
		}
		
		/* Move values into a new array, using the indices calculated
		 * above to determine the proper locations */
		Integer[] sorted = new Integer[sorting.length];
		for(int i = sorting.length-1; i > -1; i--){
			sorted[frequency[sorting[i] - lowest]--] = sorting[i];
// 			long form that we rewrote into single line above:			
//			Integer value = sorting[i];
//			int index = frequency[value - lowest]--;
//			sorted[index] = value;
		}
		
		/* Copy back to the original array */
		System.arraycopy(sorted, 0, sorting, 0, sorting.length);

	}
	
	public static <T extends CountingSortable> void countingSort(T[] array) {
		
		/* Determine range, in nice variables */
		int highest = array[0].keyMax;
		int lowest = array[0].keyMin;
		
		/* Count frequencies of different items */
		int[] frequency = new int[highest-lowest+1];
		for(int i = 0; i < array.length;i++){
			frequency[array[i].key() - lowest]++;
		}
	
		/* Convert frequencies to indices */
		frequency[0]--;
		for(int i = 1; i < frequency.length; i++){
			frequency[i] += frequency[i-1];
		}
		
		/* Move values into a new array, using the indices calculated
		 * above to determine the proper locations */
		T[] sorted = (T[]) new CountingSortable[array.length];
		for(int i = array.length-1; i > -1; i--){
			sorted[frequency[array[i].key() - lowest]--] = array[i];
		}
		
		/* Copy back to the original array */
		System.arraycopy(sorted, 0, array, 0, array.length);
		
	}

}