//Ryan McArthur, Lenny, Lemmon
//Lab12

public class AVLTree<K extends Comparable<K>, V> {
	private AVLNode root = null;

	/*
	 * true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {		
		return root == null;
	}

	/*
	 * Adds a given value indexed with a given key to the tree according to the
	 * binary search structure.  If the key is already present, this method throws
	 * a DuplicateKeyException.
	 */
	public void add(K key, V value) {
		if (isEmpty()) {
			root = new AVLNode(key, value);
		} 
		else {
			root.add(key, value);
		}
	}

	/*
	 * Returns the value associated with the given key in this binary search tree.
	 * If there is no element associated with this key, null is returned.
	 */
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		if (root == null) {
			return null;
		}
		AVLNode toReturn = root.get(key);
		if (toReturn == null) {
			return null;
		}
		return toReturn.value;
	}

	/*
	 * Clears all elements from the tree.
	 */
	public void clear() {
		root = null;
	}

	public int getHeight(K key) {
		return root.get(key).height;
	}

	private class AVLNode {
		public K key;
		public V value;
		public AVLNode leftChild = null;
		public AVLNode rightChild = null;
		public int height = 1;

		/*
		 * null key will generate a null pointer exception when
		 * a method (such as compareTo) is called on it.
		 * This is matches the Java Collections Framework specification.
		 */
		
		public AVLNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public AVLNode(K key, V value, AVLNode leftChild, AVLNode rightChild) {
			this.key = key;
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		
				private void changeFields(K key, V value, AVLNode leftChild, AVLNode rightChild) {
					this.key = key;
					this.value = value;
					this.leftChild = leftChild;
					this.rightChild = rightChild;
				}
				

		public void add(K addKey, V addValue) {

			int keyComparison = addKey.compareTo(key);
			if (keyComparison == 0) {
				throw new DuplicateKeyException(addKey);
			}
			else if (keyComparison < 0) {
				if (leftChild == null) {
					leftChild = new AVLNode(addKey, addValue);
				}
				else {
					leftChild.add(addKey, addValue);
				}
			}
			else {
				if (rightChild == null) {
					rightChild = new AVLNode(addKey, addValue);
				}
				else {
					rightChild.add(addKey, addValue);
				}
			}
			balance();
			
		}

		public AVLNode get(K getKey) {
			int keyComparison = getKey.compareTo(key);
			if (keyComparison == 0){
				return this;
			}
			else if (keyComparison < 0) {
				if (leftChild == null) {
					return null;
				}
				else {
					return leftChild.get(getKey);
				}
			}
			else {
				if (rightChild == null) {
					return null;
				}
				else {
					return rightChild.get(getKey);
				}
			}
		}
		
		public void balance(){
			
			int balanceFactor = balanceFactor();
			if (balanceFactor == 2) {
				if (leftChild.balanceFactor() == -1) { // left-right case
					leftChild.rotateLeft();
				}
				rotateRight();
			}
			else if (balanceFactor == -2) {
				if (rightChild.balanceFactor() == 1) { // right-left case
					rightChild.rotateRight();
				}
				rotateLeft();
			}
			updateHeight();
			
		}

		private void rotateRight() {
			AVLNode toMoveDown = new AVLNode(key, value, leftChild.rightChild, rightChild);
			changeFields(leftChild.key, leftChild.value, leftChild.leftChild, toMoveDown);
			rightChild.updateHeight();
			updateHeight();
		}


		private void rotateLeft() {
					AVLNode toMoveDown = new AVLNode(key, value, leftChild, rightChild.leftChild);
					changeFields(rightChild.key, rightChild.value, toMoveDown, rightChild.rightChild);
					leftChild.updateHeight();
					updateHeight();
				}

		private void updateHeight() {
			height = Math.max(getLeftHeight(), getRightHeight()) + 1;
		}

		private int getLeftHeight() {
			return (leftChild == null ? 0 : leftChild.height);
		}

		private int getRightHeight() {
			return (rightChild == null ? 0 : rightChild.height);
		}

		private int balanceFactor() {
			return getLeftHeight() - getRightHeight();
		}
	}
}