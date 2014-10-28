package exam2Study;

import java.util.ArrayList;
import java.util.Iterator;

public class SomethingIterable<E> implements Iterable<E>{
	private ArrayList<E> elements = new ArrayList<E>();

	public Iterator<E> iterator() {
		return elements.iterator();
	}

	public void add(E element) {
		elements.add(element);
	}
}
