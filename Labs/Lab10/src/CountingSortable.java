//Preston Miller, Ben Villano, Lenny Scott
public abstract class CountingSortable {
	protected static int keyMin;
	protected static int keyMax;
	
	public abstract int key();

	public static int numberOfPossibleKeys() {
		return keyMax - keyMin + 1;
	}

	public static int keyMin() {
		return keyMin;
	}
	
	public static int keyMax() {
		return keyMax; 
	}
}