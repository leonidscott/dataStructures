package exam2Study;

public class test {

	public static void main(String[] args) {
		SomethingIterable<Integer> thingy = new SomethingIterable<>();
		System.out.println(thingy.iterator());
		thingy.add(1);
		thingy.add(5);
		System.out.println(thingy.iterator().next());
		for (int i: thingy) {
			System.out.println(i);
		}
	}

}
