package pset4;

import java.util.Iterator;
import java.util.Random;

public class RandomInts implements Iterable<Integer>{
	private int min;
	private int max;
	private int n;
	private int randomNumberSeed;
	
	public RandomInts(int min, int max, int n, int randomNumberSeed) {
		if (n < 0) {
			throw new IllegalArgumentException("invalid index for n: " + n);
		}
		if (min >= max) {
			throw new IllegalArgumentException("max cannot be greater than min: min = " + min + " max = " + max);
		}
		this.min = min;
		this.max = max;
		this.n = n;
		this.randomNumberSeed = randomNumberSeed;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new randomIntIterator();
	}
	
	private class randomIntIterator implements Iterator<Integer> {
		Random randInt = new Random(randomNumberSeed);
		int intCount = 0;

		@Override
		public boolean hasNext() {
			return intCount < n;
		}

		@Override
		public Integer next() {
			int newInt = randInt.nextInt(max - min) + min;
			intCount++;
			return newInt;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
